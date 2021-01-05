package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.domain.MemberDAO;
import kr.co.ezen.CommandAction;
import kr.co.ezen.LoginDTO;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// 1. 클라이언트로부터 넘겨받는 정보가 있나?
		
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			return new CommandAction(true, "loginui.do");
		}
		
		LoginDTO login = (LoginDTO) session.getAttribute("login");
		
		if (login == null) {
			return new CommandAction(true, "loginui.do");
		}
		
		String id = request.getParameter("id");
		
		if (!id.equals(login.getId())) {
			return new CommandAction(true, "loginui.do");
		}
		// 2. dao 객체를 만들고 메서드를 호출해야하나?
		
		MemberDAO dao = new MemberDAO();
		dao.delete(id);
		
		return new CommandAction(true, "list.do");
	}

}
