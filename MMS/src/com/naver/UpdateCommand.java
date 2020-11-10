package com.naver;

import java.util.Scanner;

public class UpdateCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("수정할 ID를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("수정할 이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("수정할 나이를 입력하세요.");
		int age = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		int idx = DB.db.indexOf(dto);
		DB.db.set(idx, dto);
		
	}
	
	

}
