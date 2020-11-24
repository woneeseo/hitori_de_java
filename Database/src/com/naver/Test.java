package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
	
	public final static String DRIVE_NAME = "com.mysql.jdbc.Driver";
	public final static String URL = "jdbc:mysql://localhost:3306/mysql?serverTimezone=Asia/Seoul&useSSL=false";
	public final static String USER_NAME = "root";
	public final static String PASSWORD = "audtnr90";
	
	
	public static void main(String[] args) {
		
		try {
			Class.forName(DRIVE_NAME);
			System.out.println("드라이브 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이브 연결 실패");
			e.printStackTrace();
		}
		
		
	}
	
	public void insert() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee VALUES (?, ?, ?)";
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "e007");
			pstmt.setString(2, "seo");
			pstmt.setString(3, "홍보부");
			
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
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
	
	public void insert2(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee VALUES (?, ?, ?)";
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEid());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getDep());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
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
	
	public void delete(MemberDTO dto) {
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM employee WHERE eid = ? ";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEid());
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");

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
	
	public void delete2() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM employee WHERE eid = ? ";
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "e004");
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");

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
	
	
}

