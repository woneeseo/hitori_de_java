package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.ezen.CommandAction;
import kr.co.ezen.MemberDTO;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = dao.read(id);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "read.jsp");
		
		// read.jsp로 가는 이유 : db에서 정보를 읽어와서 화면에 띄워줘야 하므로 
	}

}
