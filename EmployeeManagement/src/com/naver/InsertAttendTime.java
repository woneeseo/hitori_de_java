package com.naver;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class InsertAttendTime implements AttendCommand{

	@Override
	public void execute(Scanner sc) {
		
		// 출근 등록 메뉴를 누르면 
		// 입력한 id 와 employeeDTO에 저장되어있는 id를 비교해
		// id 가 동일하면 현재 시간을 intime으로 저장하게 하는 메서드
		
		System.out.println("안녕하세요.");
		System.out.println("출근 시간을 등록하겠습니다.");
		System.out.println("사원 ID를 입력해주세요.");
		
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		
		EmployeeDTO oDto = dao.selectById(id);
		
		try {
			if(id == oDto.getId()) {
				System.out.println(oDto.getName()+"님의 출근 시간을 등록합니다.");
				AttendDAO aDao = new AttendDAO();
				AttendDTO aDto = new AttendDTO(id, oDto.getName(), oDto.getDep(), 
						new Date(Calendar.getInstance().getTimeInMillis()), null);
				
				aDao.insertAttend(aDto);
				
				System.out.println("출근시간이 등록되었습니다.");
			} 
			
		} catch (Exception e) {
			
			System.out.println("등록되지 않은 사원 ID입니다.");
			System.out.println("ID를 다시 한 번 확인해주세요.");

		} 
		
	}

	@Override
	public String toString() {
		return "출근시간 등록";
	}
	
	
	

}
