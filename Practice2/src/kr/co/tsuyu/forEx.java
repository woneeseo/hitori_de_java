package kr.co.tsuyu;

public class forEx {
	
	public void me1() {
		for(int i = 0; i<10; i++) {
			System.out.println("hello world");
		}
	}
	
	public void me2() {
		for(int i =0; i<101; i++) {
			System.out.println(i);
		}
	}
	
	public void me3() {
		for(int i=0; i<51; i++) {
			int c = i*2;
			System.out.println(c);
		}
	}
	
	public void me4() {
		for(int i =0; i<51; i++) {
			int c = i*2+1;
			System.out.println(c);
		}
	}
	
	public void me4(int n) {
		for(int i=0; i<n; i++) {
			int c = i*2+1;
			System.out.println(c);
		}
	}
	
	public void dan(int dan) {
		for(int i=1; i<10; i++) {
			System.out.println(dan+" x "+i+" = "+(dan*i));
		}
		
	}
	
	public void gugudan() {
		for(int i=2; i <10; i++) {
			System.out.println("----"+i+"단----");
			dan(i);
		}
		
	}
	
	public void me5() {
		for(int i=0; i<10; i++) {
			System.out.print('*');
		}
		System.out.println();
	}
	
	public void me5(int n) {
		for(int i = 0; i<n; i++) {
			System.out.print('*');
		}System.out.println();
	}
	
	public void me6() {
		for(int i=10; i>=0; i--)
			System.out.println(i);
	}
	
	public void printStar(int n) {
		for(int i=0; i<n; i++) {
			me5(i+1);
		}
	}
	
	public void halfDia() {
		int n = 10;
		for(int i=0; i<n; i++) {
			if(i<n/2) {
				me5(i+1);
			}else {
				me5(n-i-1);
			}
		}
		
	}
	
	public void isSossu(int n) {
		for(int i=2 ; i<n+1; i++) {
			if(n%i==0) {
				if(i==n) {
						System.out.println("sossu");
						
				}else {
					System.out.println("not sossu");
					break;
				}
			}
		}
	}

}