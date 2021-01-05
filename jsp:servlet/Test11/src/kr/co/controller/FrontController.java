package kr.co.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.command.InsertCommand;
import kr.co.command.InsertUICommand;
import kr.co.command.ListCommand;
import kr.co.domain.CommandAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 가장 먼저 클라이언트가 무엇을 요구했는지를 알아야 함
		//2. 다중 if문을 이용해서 command할당
		//3. Command 객체가 null이 아니면 execute()호출
		//4. 반환되는 값을 이용하여 포워딩함
		
		String uri = request.getRequestURI();
		String cpath = request.getContextPath();
		String sp = uri.substring(cpath.length());
		// servlet path : 클라이언트가 무엇을 요구했지 알 수 있는 부분
		Command coms = null;
		// command에 재정의 한 execute 메서드를 사용하기 위해서는 먼저
		// 클라이언트가 요구한 것과 맞는 command를 찾아줘야 함
		// coms 를 null값으로 지정해주고
		// if 문을 이용해서, 만약 클라이언트의 요청이 우리가 command로 구현해놓은 sp와 같으면
		// coms의 값에 command의 풀 패키지 주소를 저장해주고
		// sp와 같지 않은 경우에는 null 값을 그대로 가지게 함
		if(sp.equalsIgnoreCase("/insertui.do")) {
			coms = new InsertUICommand();
			// 만약 sp가 /insertui.do와 같다면? coms는 new InsertUICommand() 클래스를 불러온다
		} else if(sp.equalsIgnoreCase("/insert.do")) {
			coms = new InsertCommand();
		} else if(sp.equalsIgnoreCase("/list.do")) {
			coms = new ListCommand();
		} else if(sp.equalsIgnoreCase("/read.do")) {
			
		}
		
		if(coms != null) {
			// 만약 coms가 new InsertUICommand()등의 값을 가지고 있다면
			CommandAction action = coms.execute(request, response);
			// 해당 coms 가 가지고있는 execute()를 실행시킨다
			// 자바에서는 execute()의 반환형이 없었으나,
			// jsp에서는 CommandAction이라는 반환형을 가진다.
			// CommandAction : 포워딩과 관련된 정보를 가지고 있음
			
			if(action.isRedirect()) {
				// 해당 커맨드에 재정의 된 execute()를 실행한 뒤,
				// CommandAction의 반환형으로 각 클래스마다 
				// return new CommandAction(false, "list.jsp"); 와 같이 
				// return 해준 결과를 기반으로 포워딩 방법을 선택하는데,
				// 포워딩 방법이 Redirect라는 것은 전달할 자료가 없다는 의미이다
				response.sendRedirect(action.getWhere());
				 
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(action.getWhere());
				dis.forward(request, response);
			}
		} else {
			System.out.println("서비스하지 않습니다.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
