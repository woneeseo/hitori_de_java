package kr.co.ezen;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUICommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 1. 고객이 넘겨준 데이터 획득 및 가공
		// 2. DAO 객체 생성 및 해당 메서드 호출
		// 3. 반환받은 데이터를 바인딩 
		// 4. 포워딩 코드 : 추가작업을 해야하는지, 출력하면 될지를 포워딩으로 결정
		
		try {
			response.sendRedirect("insertui.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
