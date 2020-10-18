package com.naver;

public class MainEx {
	public static void main(String[] args) {
		System.out.println("hi world");
		
		String a = "hello";
		
		System.out.println(a);
		
		// 자료형은 크게 두가지로 나뉜다.
		// 기본 자료형과 참조 자료형
		// 참조자료형은 기본자료형이 아닌것이다
		// 기본자료형은 boolean, char, byte, short, int, long, float, double 의 총 8개가 있다.
		// 1. boolean : 참과 거짓만을 값으로 갖는 자료형
		boolean b = true;
		boolean c = false;
		// 2. char : 글자 하나만을 값으로 가질 수 있는 자료형. 사용시에는 값을 작은따옴표 안에 적어준다.
		char d = '밥';
		// (정수형 자료형)
		// 3. byte : 가장 작은 정수형 자료형. 1바이트(8비트)를 할당받음. 표현범위는 -128~127까지(0포함)
		// 주로 멀티미디어를 작업할 때 사용하는 함수
		byte f = 35;
		// 4. short : 정수형 자료형이지만 잘 사용하지 않는다.
		short g = 200;
		// 5. int : 정수형 자료형의 기본형. 표현범위는 대략 -21억~21억까지의 범위를 가진다. 
		int h = 473847;
		// 6. long : 정수형 자료형에서 가장 큰 표현범위를 갖는다. 사용할 때는 값 뒤에 l/L을 적어준다.
		long i = 7584957403573075894L;
		// (실수형 자료형)
		// 7. float : 비교적 정밀도가 낮은 실수형자료형. 사용할때는 값 뒤에 f/F를 붙여준다.
		float j = 3.145677F;
		// 8. double : 정밀도가 높은 실수형 자료형. 실수형 자료형의 기본이다.
		double k = 3.54536;
		
		
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		

		
		
	}

}
