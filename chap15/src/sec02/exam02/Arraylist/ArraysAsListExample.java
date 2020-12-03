package sec02.exam02.Arraylist;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("홍길동", "신용권","감자바");
		
		for(String name : list1) {
			System.out.println(name);
		}
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		// new Integer(1), new Integer(2) 와 같이 박싱을 해서 값을 넣어줘야 하지만, 
		// wrapper class를 이용하면 auto unboxing 이 되므로 정수값을 넣어도 됨
		for(int value : list2) {
			System.out.println(value);
		}
	}

}
