package com.naver;

import java.util.Scanner;

public class ExitAttendCommand implements AttendCommand{

	@Override
	public void execute(Scanner sc) {
		
		sc.close();
		System.out.println("출퇴근 입력 시스템이 종료됩니다.");
		
		System.exit(0);
		
	}

	@Override
	public String toString() {
		return "시스템 종료";
	}
	
	

}
