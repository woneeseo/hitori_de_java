package com.naver;

public class Cat {
	// 멤버변수 : 클래스의 필드 영역에서 선언된 변수
	// 클래스 영역 전체에서 유효
	// 멤버변수는 선언만 해준다. 
	boolean a;
	char b;
	byte c;
	short d;
	int e;
	long f;
	float g;
	double h;
	String msg;
	
	
	public Cat() {
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(msg);
		
		
		
	System.out.println("###############");
	
	int i = 6786;
	System.out.println(i);
	// 지역변수 : 클래스의 필드 외에서 설정된 변수
	// 선언한 이후~해당 함수의 종료표기 (})까지
	// 일반적으로 지역변수는 선언과 동시에 초기화 된다
	// 초기화 : 변수를 설정한 뒤 값을 대입하는 
	
	i = 100;
	System.out.println(i);
	// i 에 100을 대입했다.
	// 기존 값인 6786 위에 100을 덮어씌우겠다
	// 대입은 기존 변수값이 선언되어있지 않으면 성립하지 않는다
	
	j = 789;
	
	// 변수가 선언되어있지 않기 때문에 오류가 생긴것
	
	}
	
	public static void me(int i) {
		// int j 가 매개변수 
		// 이전 클래스나 매서드에서 만들어준 변수를 
		// 다음 클래스나 메서드에서 사용할 수 있도록 해주는 변
		
		System.out.println(i);
		
		int j = 899;
		System.out.println(j);
		
		
		
	}
	

}
