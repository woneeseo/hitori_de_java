package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class InsertUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 1. 클라이언트로부터 넘겨받은 데이터가 있나?
		// 2. dao객체를 만들고 메서드를 호출해야 하나?
		// 3. 바인딩 해야하나?
		// 4. 포워딩은 어디로?
		
		return new CommandAction(true, "insert.jsp");
	}

}
