package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.MemberDTO;


public class MemberDAO {
	private DataSource dataFactory;

	public MemberDAO() {
		
		try {
			Context ctx = new InitialContext();
			// Context 인터페이스이기 때문에 Context 를 상속하는 InitialContext();를 통해 객체생성
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
			// dataFactory(커넥션 풀)과 연동하기 위해서는 ctx.lookup()을 사용한다
			// context.xml에 있는 name 속성의 이름을 입력해준다.
			// ctx.lookup()는 반환형이 Object 인데, dataFactory와 연결하기 위해서
			// 형변환을 해준다. -> dataFactory와 context의 resource가 연동이 되었다는 의미
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (id, name, age) VALUES (?, ?, ?)";

		try {
	
			conn = dataFactory.getConnection();
			// .getConnection()로 커넥션으로부터 하나를 넘겨받음
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
					// 커넥션풀을 사용하고 컨테이너에 반환하는 역할을 함
					// 반환함으로써 다른 서블릿이? 커넥션풀을 사용할 수 있도록 함
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<MemberDTO> list() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member";
		ResultSet rs = null;

		try {
			//conn = SQLConnection.connect();
			conn = dataFactory.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

}