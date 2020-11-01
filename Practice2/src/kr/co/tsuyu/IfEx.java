package kr.co.tsuyu;

public class IfEx {
	
	public void me1(int a) {
		if(a%5==0) {
			System.out.println(5);
		}
	}
	
	public void me2(int a) {
		if(a%5==9 && a%6==0) {
			System.out.println(30);
		}
	}
	
	public void me3(int a) {
		if(a != 4) {
			System.out.println(true);
		}
	}
	
	public String me4(int a) {
		if(a<=10) {
			return "ok";
		}else {
			return "no";
		}
		
	}
	
	public void me5(int x) {
		if(x<0) {
			System.out.println(3);
		}else {
			System.out.println(-3);
		}
		
	}
	
	public void me6(int a) {
		if(a%2==0) {
			System.out.println(2);
		}else if(a%3==0) {
			System.out.println(3);
		}else if(a%5==0) {
			System.out.println(5);
		}else {
			System.out.println(0);
		}
	}
	
	public void me7(int score) {
		if(score >=90) {
			System.out.println('A');
		}else if(score>=80) {
			System.out.println('B');
		}else if(score>=70) {
			System.out.println('C');
		}else if(score>=60) {
			System.out.println('D');
		}else{
			System.out.println('F');
		}
	}
	
	public char me77(int score) {
		
		char result = 'A';
		
		switch (score/10) {
		case 10:
		
		case 9:
			
			break;
		case 8:
			result = 'B';
			break;
		case 7:	
			result = 'C';
			break;
		case 6:	
			result = 'D';
			break;

		default:
			result = 'F';
			break;
		}
		
		return result;
	}
	
	public void me8(int month) {
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			
			System.out.println("30일 까지 있습니다.");
			break;
		case 2:
			System.out.println("28일 까지 있습니다.");
			break;

		default:
			System.out.println("31일 까지 있습니다.");
			break;
		}
	}
	
	public void me9(int sum) {
		int a = 0;
		sum += a;
		
		System.out.println(sum);
	}

}
