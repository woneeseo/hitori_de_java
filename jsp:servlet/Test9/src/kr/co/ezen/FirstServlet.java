package kr.co.ezen;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/fs")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 데이터 바인딩하기 */
		/* 4가지 종류가 있지만 호출해서 사용하는 메서드는 모두 동일하다 */
		
		request.setAttribute("pi", 3.14);
		request.setAttribute("g", 9.8);
		request.setAttribute("name", "홍길동");
		request.setAttribute("dog", new Dog());
		
		RequestDispatcher dis = request.getRequestDispatcher("ss"); 
		/* ss -> 세컨드 서블릿의 url-pattern */
		dis.forward(request, response);
		/* dis객체는 기존에 있던 request, response를 요구했을까?*/
		/* request, response 객체를 새로 만들지 않고 그대로 사용하려고*/
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
