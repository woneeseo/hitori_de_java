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
		
		return new CommandAction(true, "insert.jsp");
		// 만약 /insertui.jsp로 /를 포함해 입력할 경우 /를 넣은 sp를 context path로 인식해
		// 주소창에 /insertui.jsp의 형태로 나타난다 (/Test202라는 컨택스트 패스가 없어진 채로 표시됨)
	}

}
