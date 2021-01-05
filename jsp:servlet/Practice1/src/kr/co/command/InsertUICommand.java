package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ezen.CommandAction;

public class InsertUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 1. 클라이언트로부터 데이터를 넘겨받았는가? no
		// 2. DAO객체를 만들고 메서드를 호출해야 하나? no
		// 3. 바인딩 할 데이터 있니? no
		// 4. 포워딩 어디로 어떻게?
		return new CommandAction(true, "insert.jsp");
	}

}
