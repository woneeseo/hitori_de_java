package sec02.exam02.Arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArraylistExam {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		// 저장할 수 있는 객체의 수가 10개 (기본용량)
		
		list.add("java");
		// 비어있는 마지막 인덱스에 string 객체를 저장 - 현재는 0번
		list.add("JDBC"); // 1번인덱스
		
		list.add("Suvlet/JSP"); // 2번인덱스 ---> 3번인덱스로 변경됨
		list.add(2, "Database"); // 2번인덱스에 삽입
		
		list.add("iBATIS");
		
		int size = list.size();
		
		System.out.println("총 객체수 : "+ size);
		
		String skill = list.get(2);
		System.out.println("2 : "+skill);
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+" : "+str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+" : "+str);
		}

	}

}
