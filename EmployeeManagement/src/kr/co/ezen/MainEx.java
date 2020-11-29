package kr.co.ezen;

import java.util.Scanner;

import com.naver.InsertAttendTime;
import com.naver.InsertEmployeeConmmand;

public class MainEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		InsertAttendTime intime = new InsertAttendTime();
		
		intime.execute(sc);
		
		InsertEmployeeConmmand newEmployee = new InsertEmployeeConmmand();
		
		// newEmployee.execute(sc);

	}

}
