package sec05.exam04_comparator;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit> {

	@Override
	public int compare(Fruit o1, Fruit o2) {
		
		if (o1.price<o2.price) {
			return -1;
			// 오름차순
			// return 1; -> 내림차순 정렬
		} else if(o1.price == o2.price){
			return 0;
		} else {
			return 1;
			// return -1; -> 내림차순 정렬
			
		}
	}

}
