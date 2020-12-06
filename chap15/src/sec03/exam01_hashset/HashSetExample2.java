package sec03.exam01_hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		// new 를 사용해 객체를 2개 생성했기 때문에 다른 객체임
		// 하지만 이름과 나이가 같음 - 동등객체가 될 수 있음
		// hashset은 동등객체여도 중복으로 인식하기 때문에 객체저장은 하나만 될 것임
		
		System.out.println("총 객체수: "+set.size());
		// 객체는 다르지만, 동등객체기 때문에 총 객체수는 1
		

	}

}
