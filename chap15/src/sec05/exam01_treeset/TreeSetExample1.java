package sec05.exam01_treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample1 {
	
	public static void main(String[] args) {
		
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		Integer score = null;
		
		score = scores.first(); 
		System.out.println("가장 낮은 점수: "+score);
		// treeset 으로 정렬된 값 중에 가장 왼쪽에 있는 값을 출력
		
		
		score = scores.last();
		System.out.println("가장 높은 점수:"+score);
		// last() 가장 오른 쪽에 있는 값을 출력
		
		score = scores.lower(new Integer(95));
		System.out.println("95점 아래 점수: "+score);
		// 95점을 부모노드로 지정해서 95점보다 아래 점수값을 가지고 있는 왼쪽 자식노드의 값이 출력됨 (87)
		
		score = scores.higher(new Integer(95));
		System.out.println("95점 위의 점수: "+score);
		
		score = scores.floor(new Integer(95));
		System.out.println("95점 이거나 바로 아래 점수: "+score);		
		// floor()는 95가 있으면 95를 출력하고, 없으면 95와 가까운 바로 아래 값을 출력함 (<> ceiling)
		// lower()는 95의 바로 아래 값을 출력함
		
		score = scores.ceiling(new Integer(85));
		System.out.println("85점 이거나 바로 위의 점수: "+score);	
		
		
		while (!scores.isEmpty()) {
			
			score = scores.pollFirst();
			// 제일 왼쪽 자식노드부터 하나씩 객체를 가져온 뒤 treeset에서 완전히 제거함
			// 빼내서 score 에 하나씩 저장해 출력
			// pollLast() -> 가장 오른쪽 노드에서부터 하나씩 가져와 저장(가장 높은 수부터 내림차순으로)
			
			System.out.println(score+"(남은 객체 수:"+scores.size()+")");
			
		}
		
//		Iterator<Integer> iterator = scores.iterator();
//		
//		while (iterator.hasNext()) {
//			int s = iterator.next();
//			iterator.remove();
//			System.out.println(s);
//			
//		}
		
		// iterator 는 객체를 가져오기만 하고 treeset에서 제거하지 않는다.
		// pollfirst()와 같은 기능을 구현하고 싶다면, remove()를 추가해주어야 함.
		
	}

}
