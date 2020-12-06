package sec04.exam02_hashtable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExmaple {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("ID와 비밀번호를 입력해주세요.");
			System.out.print("아이디: ");
			String id = sc.nextLine();
			
			System.out.print("비밀번호: ");
			String password = sc.nextLine();
			System.out.println();
			
			if(map.containsKey(id)) {
				// map에 입력되어있는 key중에 입력받은 id 와 같은 값이 있니?
				// 있으면 아래 실행, 없으면 id가 존재하지 않습니다 출력
				if(map.get(id).equals(password)) {
					// id가 존재할 때, key가 가지고 있는 값이 password와 동등하니?
					// 동등하면 로그인 성공
					System.out.println("로그인 되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					// 동등하지 않으면 비밀번호가 일치하지 않습니다 출력S
				}
			} else {
				System.out.println("ID가 존재하지 않습니다.");
			}
		}
		
		
		
		sc.close();
	}

}
