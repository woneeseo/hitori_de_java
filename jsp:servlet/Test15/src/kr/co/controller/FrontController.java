package kr.co.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.command.DeleteCommand;
import kr.co.command.InsertCommand;
import kr.co.command.InsertUICommand;
import kr.co.command.ListCommand;
import kr.co.command.LoginCommand;
import kr.co.command.LoginUICommand;
import kr.co.command.LogoutCommand;
import kr.co.command.ReadCommand;
import kr.co.command.UpdateCommand;
import kr.co.command.UpdateUICommand;
import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();
		String cpath = request.getContextPath();
		String sp = uri.substring(cpath.length());
	
		Command com = null;

		if (sp.equalsIgnoreCase("/insertui.do")) {
			com = new InsertUICommand();
		} else if (sp.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		} else if (sp.equalsIgnoreCase("/list.do")) {
			com = new ListCommand();
		} else if (sp.equalsIgnoreCase("/read.do")) {
			com = new ReadCommand();
		} else if (sp.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		} else if (sp.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		} else if (sp.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		} else if (sp.equalsIgnoreCase("/loginui.do")) {
			com = new LoginUICommand();
		} else if (sp.equalsIgnoreCase("/login.do")) {
			com = new LoginCommand();
		} else if (sp.equalsIgnoreCase("/logout.do")) {
			com = new LogoutCommand();
		}

		if (com != null) {

			CommandAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(action.getWhere());
				dis.forward(request, response);
			}
		} else {

			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("해당 서비스는 제공하고 있지 않습니다.");
			out.print("</body>");
			out.print("</html>");
		}

		// 매번 추가해야하는 불편함 + 유지보수가 불편함을 개선하기 위해 맵을 사용함
		// map 과 reflection을 이용해서 코드 정리
		// 다중 if문과 같은 기능을 가졌으나 유지보수는 훨씬 편리하다.

//		MemberDAO dao = new MemberDAO();
//		Map<String, String> menus = dao.menuMap();
//		
//		String fullname = menus.get(sp.toLowerCase());
//		
//		if(fullname != null) {
//			
//			try {
//				
//				Class<?> testClass = Class.forName(fullname);
//				Constructor<?> cons = testClass.getConstructor();
//				com = (Command) cons.newInstance();
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			CommandAction action = com.execute(request, response);
//			
//			if(action.isRedirect()) {
//				response.sendRedirect(action.getWhere());
//			} else {
//				RequestDispatcher dis = request.getRequestDispatcher(action.getWhere());
//				dis.forward(request, response);
//			} 
//			
//		} else { 
//			
//			PrintWriter out = response.getWriter();
//			out.print("<html>");
//			out.print("<body>");
//			out.print("해당 서비스는 제공하고 있지 않습니다.");
//			out.print("</body>");
//			out.print("</html>");
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
