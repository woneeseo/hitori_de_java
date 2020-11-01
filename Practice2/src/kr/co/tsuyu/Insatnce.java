package kr.co.tsuyu;

public class Insatnce {
	
	public boolean me1(int a, int b) {
		boolean c = a > b;
		return c;
	}
	
	public boolean me2(long a, long b) {
		 boolean c = a >= b;
		 return c;
	}
	
	public String me3(float a, float b) {
		boolean c = a < b;
		if(c) {
			return "ok";
		}else {
			return "no";
		}
	}
	
	public boolean me4(byte a, byte b) {
		boolean c = a <= b;
		return c;
	}
	
	public boolean me5(short a, short b) {
		boolean c = a == b;
		return c;
	}
	
	public void me51(boolean a, boolean b) {
		boolean c = a == b;
		System.out.println(c);
	}
	
	public void me6(boolean a,boolean b) {
		boolean c = a != b;
		System.out.println(c);
	}
	
	public void con1(int a, int b) {
		char c = a >= b ? 'a' : 'z' ;
		System.out.println(c);
	}
	
	public void con2(int a, int b) {
		String c = a != b ? new String("hello") : new String("no");
		System.out.println(c);
	}
	
	public void con3(int a, int b) {
		StringBuffer c = a <= b ? new StringBuffer("hello") : new StringBuffer("no");
		System.out.println(c);
	}
	
	public void con5(int score) {
		char c = score >= 90 ? 'A'
				: score >= 80 ? 'B'
						:score >= 70 ? 'C'
								:score >= 60 ? 'D' : 'F';
		System.out.println(c);
	}

}
