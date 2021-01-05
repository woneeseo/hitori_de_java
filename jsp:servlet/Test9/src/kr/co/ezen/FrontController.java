package kr.co.ezen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String uri = request.getRequestURI();
		String cpath = request.getContextPath();
		String sp = uri.substring(cpath.length());
		
		// sp(servlet path)로 클라이언트가 어떤 경로로 요청을 했는지를 확인할 수 있다.
		
		Command coms = null;
		
		if(sp.equalsIgnoreCase("/insertui.do")) {
			coms = new InsertUICommand();
		} else if(sp.equalsIgnoreCase("/insert.do")) {
			coms = new InsertCommand();
		}
		
		if(coms != null) {
			coms.execute(request, response);
			
		} else {
			System.out.println(sp+"는 서비스 하지 않습니다.");
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
