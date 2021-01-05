package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class InsertUICommand implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		// 커맨드 클래스에서 하는 일
		
		// 1. 클라이언트가 보내준 데이터 획득 및 가공 -> 현재 커맨드에는 없음
		// 2. DAO객체의 생성 밎 해당 메서드 호출 -> DB에서 가져올 데이터 없음
		// 3. data binding -> 받은 데이터가 없기 때문에 binding 할 필요성도 없음
		
		// 4. forwarding 
		
		return new CommandAction(true, "insertui.jsp");
		// 바인딩해서 넘겨줄 데이터가 없기 때문에 true 
		// (isRedirect=true redirect방식으로 포워딩 하겠다는 의미)
		
		// frontController로 갈때는 where를 .do로
		// 화면으로 갈 때는 .jsp 로 넣어준다
	}

}
