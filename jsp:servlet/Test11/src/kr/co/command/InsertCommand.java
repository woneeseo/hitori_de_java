package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		//1. 클라이언트가 보내준 데이터 획득 밎 가공
		//2. DAO객체 생성 밎 해당 메서드 호출
		//3. data binding -- 일반적으로는 request / session(로그인관련) / application(방문자수관련)
		//4. 포워딩
		
		//1. 클라이언트가 보내준 데이터 획득 밎 가공
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		// getParameter()를 이용해 데이터를 가져온다
		// 웹 브라우저에서 가져온 데이터는 숫자로 입력되더라도 문자열로 인식되기 때문에
		// parseInt()를 이용해 int형으로 가공해줘야 한다
		int age = Integer.parseInt(sAge);
		
		//2. DAO객체 생성 밎 해당 메서드 호출
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		//3. 반환하는 데이터가 없으므로 binding은 필요 없음
		
		return new CommandAction(true, "list.do");
		//4. 포워딩 -> CommandAction 객체를 이용한다
	}

}
