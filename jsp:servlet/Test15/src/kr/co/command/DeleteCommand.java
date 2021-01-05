package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession(false);
		// 저장된 session이 있는지 먼저 확인할 것
		if(session == null) {
			return new CommandAction(true, "loginui.do");
		}
		
		LoginDTO login = (LoginDTO) session.getAttribute("login");
		// 세션이 있다면, login이라는 데이터와 바인딩이 되어있는가?
		// login 과 바인딩 여부 : logincommand에서 확인할 수 있
		
		if (login == null) {
			return new CommandAction(true, "loginui.do");
			// 바인딩 된 데이터가 없다 -> 로그인 화면으로 돌려보냄
		}
		
		
		// 현재는 한 아이디로 로그인이 되면 나머지 모든 회원 정보에 접근해 삭제가 가능한 상태이다.
		// 따라서 입력받은 로그인 한 id 와 삭제를 요청하는 id가 같지 않으면
		// 다시 로그인 화면으로 돌려보내 정상적인 id로 접근할 수 있도록 해야 한다.
		
		String id = request.getParameter("id");
		
		if(!id.equals(login.getId())) {
			
			// 입력받은 id 아래쪽 코드에 
			// session에 저장된 login정보와 id가 같은지 비교하는 코드로 if문을 작성한다
			// 코드가 같으면 정상적으로 삭제를 진행하지만, 코드가 다르면 다시 로그인 화면으로 돌아가도록 한다.
			
			return new CommandAction(true, "loginui.do");
		}
		
		MemberDAO dao = new MemberDAO();
		
		dao.delete(id);
		
		return new CommandAction(true, "list.do");
	}

}
