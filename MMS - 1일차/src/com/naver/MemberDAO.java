package com.naver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/mysql";
	private final String USER_NAME = "root";
	private final String PASSWORD = "audtnr90";
	
	public MemberDAO() {
		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<MemberDTO> select() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String eid = rs.getString("eid");
				String ename = rs.getString("ename");
				String dep = rs.getString("dep");
				int telNum = rs.getInt("telNum");
				String gread = rs.getString("gread");
				Date birth = rs.getDate("birth");
				
				MemberDTO dto = new MemberDTO(eid, ename, dep, telNum, gread, birth);
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
	
	
	
	
	
	public MemberDTO selectByEid(String eid) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee WHERE eid = ? ";
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, eid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String ename = rs.getString("ename");
				String dep = rs.getString("dep");
				int telNum = rs.getInt("telNum");
				String gread = rs.getString("gread");
				Date birth = rs.getDate("birth");
				
				dto = new MemberDTO(eid, ename, dep, telNum, gread, birth);
				
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
		
		return dto;
	}
	
	
	public void update(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE employee SET ename = ?, dep = ?, telNum = ?, gread = ?, birth = ? WHERE eid = ? ";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEname());
			pstmt.setString(2, dto.getEid());
			pstmt.setInt(3, dto.getTelNum());
			pstmt.setString(4, dto.getDep());
			pstmt.setDate(5, dto.getBirth());
			pstmt.setString(6, dto.getEid());
			
			int result = pstmt.executeUpdate();
			if(result != 0) {
				System.out.println("사원 정보 수정 완료.");
			} else {
				System.out.println("사원 정보 수정 실패 / 다시 한 번 확인해주세요.");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	}
	
	
	
	
	public void delete(String eid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM employee WHERE eid = ? ";
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, eid);
			
			int result = pstmt.executeUpdate();
			if(result != 0) {
				System.out.println("사원정보 삭제 완료");
			} else {
				System.out.println("사원정보 삭제 불가 / ID를 다시 확인해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
		
	}
	
	
	
	public void insert(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEid());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getDep());
			pstmt.setInt(4, dto.getTelNum());
			pstmt.setString(5, dto.getGread());
			pstmt.setDate(6, dto.getBirth());
			
			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("사원 등록이 완료되었습니다.");
			} else {
				System.out.println("사원 등록이 실패하였습니다. 다시 시도해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	}
	
	public Date stringTransformDate(String date) {
		
		SimpleDateFormat beforeDate = new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat afterDate = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			tempDate = beforeDate.parse(date);
			
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String teansDate = afterDate.format(tempDate);
		Date birth = Date.valueOf(teansDate);
		
		return birth;
		
	}
	

}
