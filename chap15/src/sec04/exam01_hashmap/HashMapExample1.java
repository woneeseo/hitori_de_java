package sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90); // key가 중복되면 이전 키값이 새로운 값으로 대치
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		System.out.println("총 Entry수: "+map.size());
		
		System.out.println("홍길동: "+map.get("홍길동"));
		// 마지막으로 "홍길동"의 value값으로 입력한 95가 출력됨
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			int value = map.get(key);
			System.out.println("\t"+key+ " : "+value);
		}
		
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 Entry수: "+map.size());
		
		// entryset을 이용해서 모든 값 가져오기
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while (entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println("\t"+key+ " : "+value);
		}
		
		System.out.println();
		map.clear();
		System.out.println("총 Entry수: "+map.size());

	}

}
