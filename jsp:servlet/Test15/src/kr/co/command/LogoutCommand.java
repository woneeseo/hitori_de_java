package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.domain.CommandAction;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 로그아웃은 DB와 관련이 없다. 
		// 로그아웃을 하기 위해서는  login의 값과 session이 있어야 한다
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			// session 을 제거하는 메서
			session.invalidate();
			// session.removeAttribute("login"); 
			// 위의 방법으로 사용해도 되지만 일반적으로는 invaliate()를 더 많이 씀
			
			return new CommandAction(true, "list.do");
		}
		
		return new CommandAction(true, "list,do");
	}

}
