package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 1. 사용자로부터 데이터를 입력받는가?
		// 2. DTO클래스를 만들어야하나?
		// 3. 데이터 바인딩을 해야하나?
		// 4. 포워딩은?

		HttpSession session = request.getSession(false);

		if (session == null) {
			return new CommandAction(true, "loginui.do");
		}
		
		LoginDTO login = (LoginDTO) session.getAttribute("login");
		
		if(login == null) {
			return new CommandAction(true, "loginui.do");
		}
		

		String id = request.getParameter("id");
		// 사용자로부터 update하고자 하는 id 를 가져와서
		if(!id.equals(login.getId())) {
			return new CommandAction(true, "loginui.do");
		}
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.updateui(id);
		// dao클래스에 만들어 둔 updateui()를 이용해
		// 입력받은 id가 가진 나머지 값을 가져와 dto객체를 만들어서
		// update.jsp 로 띄위서 넘겨준다

		request.setAttribute("dto", dto);
		// 넘겨줄 자료가 있으므로 request객체에 바인딩

		return new CommandAction(false, "update.jsp");
		// 바인딩 해준 객체가 있으므로 포워딩 방식은 dispatcher로,
		// 수정 받을 정보를 입력받기 위해 .jsp화면을 띄운
	}

}
