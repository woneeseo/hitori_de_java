package kr.co.ezen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourServlet
 */

public class YourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 초기화 파라미터 : 데이터의 보안을 위해 사용한다.
		// init-Param을 적용한 데이터는 파라미터가 적용된 서블릿 내에서만 유효하기 때문에
		// 다른 서블릿 스코프 안에서는 인식되지 않고 null값을 반환한다.
		
		response.setContentType("text/html;charset=utf-8");
		
		String username = getInitParameter("username");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print(name);
		out.print("<br>");
		out.print(address);
		out.print("<br>");
		out.print(username);
		// 서블릿의 스코프를 벗어났기 때문에 인식되지 않고 null값이 나옴
		out.print("</body>");
		out.print("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String school = request.getParameter("school");
		String[] arrHobby = request.getParameterValues("hobby");
		
	
		
		out.print("<html>");
		out.print("<body>");
		out.print(school);
		out.print("<br>");
		for(int i=0; i<arrHobby.length; i++) {
			out.print(arrHobby[i]+"<br>");
		}
		
		out.print("</body>");
		out.print("</html>");
		
	}

}
