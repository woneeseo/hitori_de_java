package sec05.exam01_treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample2 {

	public static void main(String[] args) {
		
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		
		for(Integer score : descendingSet) {
			System.out.print(score+" ");
		}
		System.out.println();
		
		NavigableSet<Integer> asendingSet = descendingSet.descendingSet();
		// desendingSet + descendingSet = 오름차순으로 정렬됨
		
		for(Integer score : asendingSet) {
			System.out.print(score+" ");
		}
		
		

	}

}
