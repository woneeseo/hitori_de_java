package kr.co.tsuyu;

import java.util.Scanner;

import com.naver.Command;
import com.naver.DeleteCommand;
import com.naver.InsertCommand;
import com.naver.SelectCommand;
import com.naver.UpdateCommand;

public class MainEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Command[] coms = {
				new InsertCommand(), new SelectCommand(),
				new UpdateCommand(), new DeleteCommand()
		};
		
		boolean isOk = true;
		int idx = -1;
		
		while(isOk) {
			
			System.out.println("메뉴를 선택하세요.");
			System.out.println("0:회원등록, 1:회원조회, 2:회원정보 수정, 3:회원삭제, 4:종료");
			
			idx = sc.nextInt();
			sc.nextLine();
			
			if(idx==coms.length) {
				break;
			}
			
			coms[idx].execute(sc);
		}
		
		
		
		
		
		System.out.println("프로그램을 종료합니다.");
		
		sc.close();

	}

}
