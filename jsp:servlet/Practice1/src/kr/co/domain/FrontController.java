package kr.co.domain;

import java.io.IOException;
import java.io.PrintWriter;

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
import kr.co.ezen.CommandAction;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uri = request.getRequestURI();
		String cpate = request.getContextPath();
		String sp = uri.substring(cpate.length());
		
		Command com = null;
		
		if(sp.equalsIgnoreCase("/insertui.do")){
			com = new InsertUICommand();
		} else if(sp.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		} else if(sp.equalsIgnoreCase("/list.do")) {
			com = new ListCommand();
		} else if(sp.equalsIgnoreCase("/read.do")) {
			com = new ReadCommand();
		} else if(sp.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		} else if(sp.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		} else if(sp.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		} else if(sp.equalsIgnoreCase("/loginui.do")) {
			com = new LoginUICommand();
		} else if(sp.equalsIgnoreCase("/login.do")) {
			com = new LoginCommand();
		} else if(sp.equalsIgnoreCase("/logout.do")) {
			com = new LogoutCommand();
		}
		
		if(com != null) {
			CommandAction action = com.execute(request, response);
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				RequestDispatcher dis= request.getRequestDispatcher(action.getWhere());
				dis.forward(request, response);
			}
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("지원하고 있지 않은 서비스입니다.");
			out.print("</body>");
			out.print("</html>");
			
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