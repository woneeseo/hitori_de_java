package kr.co.ezen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/ss")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object pi = request.getAttribute("pi");
		Object g = request.getAttribute("g");
		Object name = request.getAttribute("name");
		Object dog = request.getAttribute("dog");
		
		Object hello = request.getAttribute("hello");
		Object pw = request.getAttribute("pw");
		
		
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("ss");
		out.print("<br>");
		out.print(pi);
		out.print("<br>");
		out.print(g);
		out.print("<br>");
		out.print(name);
		out.print("<br>");
		out.print(dog);
		out.print("<br>");
		out.print("************");
		out.print(hello);
		out.print("<br>");
		out.print(pw);
		out.print("</body>");
		out.print("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
