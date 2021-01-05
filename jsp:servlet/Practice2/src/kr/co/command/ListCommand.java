package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDAO;
import kr.co.ezen.MemberDTO;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// 1. 클라이언트에게 받아온 정보가 있나?
		// 2. dao객체를 만들고 해당 메서드를 불러와야 하나?
		// 3. 바인딩?
		// 4. 포워딩은 어디로? 어떻게?
		
		MemberDAO dao = new MemberDAO();
		
		List<MemberDTO> list = dao.list();
		
		request.setAttribute("list", list);
		
		return new CommandAction(false, "list.jsp");
	}

}
