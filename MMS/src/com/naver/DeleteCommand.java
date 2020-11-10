package com.naver;

import java.util.Scanner;

public class DeleteCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("삭제할 ID를 입력하세요.");
		
		String id = sc.nextLine();
		
		boolean b = DB.db.remove(new MemberDTO(id, null, 0));
		if(b) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("삭제 실패 - 없는 사용자입니다.");
		}
	}
	
	

}
