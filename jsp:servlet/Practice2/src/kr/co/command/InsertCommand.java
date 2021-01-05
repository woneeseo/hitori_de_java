package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDAO;
import kr.co.ezen.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 1. 클라이언트로부터 넘겨받은 정보가 있나?
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		
		int age = Integer.parseInt(sAge);
		
		// 2. DTO객체를 만들고 메서드를 호출해야하나?
		
		MemberDTO dto = new MemberDTO(id, name, age);
		MemberDAO dao = new MemberDAO();
		
		dao.insert(dto);
		
		// 3. 데이터 바인딩을 할 필요가 있나? x
		
		// 4. 포워딩은 어디로 어떻게?
		
		return new CommandAction(true, "list.do");
	}

}
