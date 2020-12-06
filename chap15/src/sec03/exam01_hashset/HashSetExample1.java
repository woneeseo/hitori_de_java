package sec03.exam01_hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample1 {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("sublet/JSP");
		set.add("Java"); // 첫번째 add한 java 가 마지막으로 저장한 java로 대체됨 (중복허용x)
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체수: "+size);
		
		Iterator<String> iteartor = set.iterator();
		while (iteartor.hasNext()) {
			String element = iteartor.next();
			System.out.println("\t"+element);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("총 객체수: "+set.size());
		
		for(String element : set) {
			
			System.out.println("\t"+element);
		}
		
		set.clear();
		if (set.isEmpty()) {
			System.out.println("비어있음");
		}

	}

}
