package sec05.exam01_treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {

	public static void main(String[] args) {
		
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[c~f사이의 단어를 검색]");
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
		// subset() : c부터 시작, c포함할거야? 응(true)/아니(false), f까지, f포함할거야? 웅(true)/아니(false)
		for(String word : rangeSet) {
			System.out.println(word);
		}

	}

}
