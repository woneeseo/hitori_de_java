package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.BoardDTO;

public class BoardDAO {

	private DataSource dataFatory;

	public BoardDAO() {

		try {
			Context ctx = new InitialContext();
			dataFatory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		try {
			if (rs == null) {
				rs.close();
			}
			if (pstmt == null) {
				pstmt.close();
			}
			if (conn == null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(BoardDTO dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO myboard (num, author, title, content, repRoot, repStep, repIndent) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		// writeday , readcnt : sql에서 default값을 지정해뒀기 때문에 외부에서 입력해 줄 필요 없음

		try {

			conn = dataFatory.getConnection();
			int num = getNum(conn);

			// getNum() : NVL2가 자동으로 부여해준 num값을 도출해내는 메서드

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);

			// 원글을 작성하는 경우, repRoot값은 글번호(num)값과 동일하기 때문에 파라미터에 num값을 주고
			// repStep은 답글간의 서열정리를 할 때 필요한 값이기 때문에 값을 줄 필요가 없고,
			// repIndent도 답글인 경우 들여쓰기를 하기 위해 지정한 컬럼이기 때문에 원글에서는 0을 값으로 주면 된다.

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	private int getNum(Connection conn) {

		int num = -1;
		// insert()에 num을 넘겨줘야하기 때문에, int num 변수를 먼저 설정해준다.
		// 메서드가 실행 완료되면 DB에서 num을 넘겨받아 return해준다.
		// (초기화 변수값이 -1 이 아니어도 상관없지만 보통 -1을 많이 씀)
		PreparedStatement pstmt = null;
		String sql = "SELECT NVL2(MAX(num), MAX(num)+1, 1) FROM myboard";

		// NVL2(MAX(num), MAX(num)+1, 1) 의 의미 :
		// myboard에서 max num(가장 큰 num값)값을 가져오는데, 만약 num값이 null이면 1을 가져오고
		// num값이 1이 아니면, max num에 1을 더해줘라

		// NVL2를 쓰는 이유? 자동으로 글 번호를 먹여주기 위해서 -> sql에서 따로 num값을 일일히 지정해주지 않아도 된다.
		// 새로 들어가는 글번호가 자동으로 현재 저장된 글 수 +1 되어서 저장됨

		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
				// 가져와야 할 컬럼이 num뿐이므로 1이라고 해도 됨
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
			// conn을 null로 지정한 이유?
			// getNum()의 경우, insert()에서 num값을 얻어내기 위해 만든 메서드이다
			// insert()안에서 커넥션풀을 빌려 실행된 후 conn을 다시 insert에게 넘겨줘야 하기 때문에
			// getNum()에서 conn을 닫아버리면 getNum()이후에 짜여진 코드들이 실행되지 못하고 종료되어 버린다.
		}
		return num;
	}

	public List<BoardDTO> list() {

		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT num, author, title, to_char(writeday,'yyyy/mm/dd') writeday, readcnt, repRoot, repStep, repIndent FROM myboard ORDER BY repRoot desc, repStep asc";

		// to_char(writeday,'yyyy/mm/dd') writeday : date형으로 받은 writeday의 표시형식을 연/월/일로
		// 바꿔줌
		// + 형식을 변경해준 뒤 별칭으로 writeday를 설정해, getString에서 가져올 수 있도록 함
		// 불러오기 할 때 반드시, ORDER BY repRoot desc, repStep asc !! :
		// 정렬조건 없이 리스트를 불러오면 num값 순서대로 정렬되기 때문에 원글과 답글이 묶여있지 못한다
		// 원글과 답글이 묶일 수 있도록 + 답글간의 서열을 정해 정렬할 수 있도록 정렬조건을 반드시 입력해 select문을 입력한다.

		try {
			conn = dataFatory.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int num = rs.getInt("num");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");

				BoardDTO dto = new BoardDTO(num, author, title, null, writeday, readcnt, repRoot, repStep, repIndent);
				// content를 호출하지 않은 이유 : 글 내용은 글 자세히 보기에서 확인할 수 있기 때문에
				// 글목록을 보여주는 list()에서는 content값을 가져올 필요가 없다.

				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	public BoardDTO read(int num) {

		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM myboard WHERE num = ? ";
		boolean isOK = false; 
		/* 트랜잭션을 위해서 선언한 변수, isOK가 false값을 유지한다면 정상적으로 작입이 이루어졌다는 이야기 */

		// read.jsp에서 ${dto.num}으로 값을 넘겨줬으므로, num을 이용해 찾기 : num은 pk이기 때문에 검색결과도 단 하나만
		// 나온다.

		try {
			conn = dataFatory.getConnection();
			conn.setAutoCommit(false);
			increaseReadcnt(conn, num);

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");

				dto = new BoardDTO(num, author, title, content, writeday, readcnt, -1, -1, -1);

			}
			
			isOK = true;

		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				if (isOK) {
					conn.commit();
				} else {
					conn.rollback();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			// 트랜잭션 순서 : boolean형의 isOK변수를 선언해 false로 초기화한다
			// 커넥션의 autocommit을 해제해준다 (파라미터로 false)
			// try문의 마지막 행에 isOK=true; 를 대입해준다. 코드가 정상적으로 실행되었다면 isOK는 true 값을 가진다
			// finally 블록에서 트랜잭션 처리를 한다.
			// 넘겨받은 isOK의 값이 true라면? -> commit();
			// 그렇지 않고 false라면 rollback();
			// 묶어서 try-catch를 해준다.
			
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	private void increaseReadcnt(Connection conn, int num) {

		// 조회수를 1씩 올려주기 위해 사용하는 메서드.
		// num은 read()에서 넘겨받는 파라미터를 그대로 사용할 수 있도록 increas의 파라미터에도 num을 설정해준다

		PreparedStatement pstmt = null;
		String sql = "UPDATE myboard SET readcnt = readcnt +1 WHERE num = ?";
		
		// where 조건이 없이 update문을 작성하게 되면,
		// db에 저장되어있는 모든 데이터의 readcnt 수가 +1이 되므로 where조건을 반드시 넣어줄것
		// where 의 num 값은 read에서 넘어오는 파라미터 값을 그대로 쓸 수 있도록 inc~()에도 파라미터로 num값을 넘겨준다
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}

	public BoardDTO updateui(int num) {
		
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM myboard WHERE num = ? ";
		
		try {
			conn = dataFatory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				
				dto = new BoardDTO(num, author, title, content, writeday, readcnt, 0, 0, 0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}

	public void update(BoardDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE myboard SET title = ?, author = ?, content=?, writeday=sysdate WHERE num=?";

		
		try {
			conn = dataFatory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAuthor());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void delete(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM myboard WHERE num = ? ";
		
		try {
			conn = dataFatory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

}
