package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/mysql";
	private final String USER_NAME = "root";
	private final String PASSWORD = "audtnr90";
	
	public EmployeeDAO() {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<EmployeeDTO> selectEmployee() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee";
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				String dep = rs.getString("dep");
				int tel = rs.getInt("tel");
				
				EmployeeDTO dto = new EmployeeDTO(id, name, dep, tel);
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}
	
	
	public EmployeeDTO selectByName(String name) {
		
		EmployeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee WHERE name = ? ";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String id = rs.getString("id");
				String dep = rs.getString("dep");
				int tel = rs.getInt("tel");
				
				dto = new EmployeeDTO(id, name, dep, tel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	public EmployeeDTO selectById(String id) {
		
		EmployeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee WHERE id = ? ";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String name = rs.getString("name");
				String dep = rs.getString("dep");
				int tel = rs.getInt("tel");
				
				dto = new EmployeeDTO(id, name, dep, tel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return dto;
	}
	
	public void deleteEmployee(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM employee WHERE id = ? ";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	
	
	public void insertEmployee(EmployeeDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getDep());
			pstmt.setInt(4, dto.getTel());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
