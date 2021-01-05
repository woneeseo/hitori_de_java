package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public interface Command {
	
	public abstract CommandAction execute(HttpServletRequest request, HttpServletResponse response
			)throws IOException, ServletException;
	
	// CommandAction : 포워딩과 관련된 정보를 가지고 있는 클래스
	// execute()를 실행한 뒤 CommandAction 객체를 반환하게 함
	// 어떤 데이터를 반환하는가? 어떤 방식으로 포워딩할것인가 & 어디로 포워딩 할것인가
	
	// 파라미터에는 서블릿의 doGet() 이나 doPost()에 사용하는 request/response 를 사용한다
	
}
