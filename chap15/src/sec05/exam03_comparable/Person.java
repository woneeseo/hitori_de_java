package sec05.exam03_comparable;

public class Person implements Comparable<Person>{

	public String name;
	public int age;
	
	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Person o) {
		if (age<o.age) {
			return -1;
		} else if(age == o.age){
			return 0;

		} else {
			return 1;
		}
	}

}
