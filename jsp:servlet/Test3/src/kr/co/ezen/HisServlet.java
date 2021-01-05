package kr.co.ezen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HisServlet
 */

public class HisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// context 파라미터 : 프로젝트 어디에서든 접근할 수 있는 파라미터
		// web.xml파일은 외부에서 절대 접근할 수 없을만큼 보안성이 높으나,
		// <context-param> 안에서 name 값과 value값을 입력해 준 데이터에 한해서는
		// 프로젝트 어디에서든지 접근이 가능하다.
		// context는 application이라고 부르기도 하며, 프로젝트라고도 한다.
		
		String url = getInitParameter("url");
		System.out.println(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
