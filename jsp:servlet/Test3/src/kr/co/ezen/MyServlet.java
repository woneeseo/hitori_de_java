package kr.co.ezen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext application = getServletContext();
		
		String drivername = application.getInitParameter("drivername");
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("안녕하세요");
		out.print("<br>");
		out.print(drivername);
		out.print("</body>");
		out.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//　클라이언트가 서버로 보내는 한글 데이터도 깨진다
		// 따라서, request객체도 한글 인코딩을 따로 해줘야 한다.
		// setCharacterEncoding("utf-8"); 를 이용한다
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// jsp로 웹에서 입력받은 값을 가져와 브라우저에 출력할 수 있도록 해주는 메서드
		// request.getParameter("input 태그가 가진 name속성의 값");
		// 클라이언트로부터 값을 입력받기 때문에 request객체를 사용해야 한다
		// <input (Parameter) name="id"> 이기 때문에 getParameter() 를 사용한다.
		

		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("식사하셨습니까?<br>");
		out.print(id+"<br>");
		out.print(pw+"<br>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
