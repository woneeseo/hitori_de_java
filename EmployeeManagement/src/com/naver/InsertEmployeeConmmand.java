package com.naver;

import java.util.Scanner;

public class InsertEmployeeConmmand implements EmployeeCommand{

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("사원 등록을 시작합니다.");
		System.out.println("사원 ID를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("사원의 이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("부서를 입력하세요.");
		System.out.println("a: 인사부, b: 영업부, c: 경리부, d: 홍보부, e: 인턴사원");
		String dep = sc.nextLine();
		
		System.out.println("연락처를 입력해주세요.");
		System.out.println("(- 없이 번호만 입력해주세요.)");
		int tel = sc.nextInt();
		
		EmployeeDTO dto = new EmployeeDTO(id, name, dep, tel);
		EmployeeDAO dao = new EmployeeDAO();
		dao.insertEmployee(dto);
		
		System.out.println("사원등록을 완료하였습니다.");
		System.out.println("출퇴근 시스템의 이용이 가능합니다.");
		
	}

	@Override
	public String toString() {
		return "사원정보 등록";
	}
	
	

	
}
