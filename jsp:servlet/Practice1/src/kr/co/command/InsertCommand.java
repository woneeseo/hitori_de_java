package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.ezen.CommandAction;
import kr.co.ezen.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 1. 클라이언트로부터 데이터를 받아오는가? ㅇ
		// 2. DAO 객체를 만들고 해당 메서드를 호출해야하는가? ㅇ
		// 3. 바인딩 할 데이터가 있나? ㄴ
		// 4. 포워딩은 어디로 어떻게? 
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		
		int age = Integer.parseInt(sAge);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id, name, age);
		
		dao.insert(dto);
		
		return new CommandAction(true, "list.do");
	}

}
