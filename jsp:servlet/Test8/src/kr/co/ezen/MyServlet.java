package kr.co.ezen;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("*.do")
// *.do : 모든 .do로 끝나는 확장자형패턴을 받을 수 있도록 해줌
// insert.do (x) : 그냥 .do로 해야 확장자패턴이 .do인 모든 url-pattern을 받을 수 있음
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
		
		String uri = request.getRequestURI();
		String cpath = request.getContextPath();
		String sp = uri.substring(cpath.length());

		System.out.println(uri);
		System.out.println(cpath);
		System.out.println(sp);	
		
		if(sp.equalsIgnoreCase("/insert.do")){
			System.out.println("입력");
		} else if(sp.equalsIgnoreCase("/insertui.do")) {
			System.out.println("입력화면");
		} else {
			System.out.println("조회");
		}
		
		// 이 부분은 유지 보수가 힘들기 때문에 map 과 reflection을 이용해서 
		// 코드를 구성해줘야 한다. (학습용으로는 if else를 쓰긴 하지만...)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
