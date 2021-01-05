package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;

public class LoginCommand implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String sAge = request.getParameter("pw");
		
		int age = Integer.parseInt(sAge);
		
		LoginDTO loginDTO = new LoginDTO();
		
		loginDTO.setId(id);
		loginDTO.setAge(age);
		
		MemberDAO dao = new MemberDAO();
		
		LoginDTO login = dao.login(loginDTO);
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30);
		session.setAttribute("login", login);
		
		return new CommandAction(true, "list.do");
	}

}
