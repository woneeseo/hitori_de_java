package sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 90);
		
		// key값은 중복될 수 없기 때문에 size는 1이 나옴
		
		System.out.println("총 Entry수: "+map.size());
		System.out.println(map.get(new Student(1, "홍길동")));
		
		// key값이 같은 동등객체는 나중에 입력된 값이 대체되므로
		// (new Student(1, "홍길동"))의 value값을 가져오면 90이 출력된다.
		
		

	}

}
