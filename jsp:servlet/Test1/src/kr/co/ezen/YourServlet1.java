package kr.co.ezen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourServlet1
 */

public class YourServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YourServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 서버가 클라이언트에게 "안녕하세요" 를 보여주겠습니다.
		
		response.setContentType("text/html;charset=utf-8");
		// 브라우저에 한글을 "출력" 할 것이기 때문에 response객체를 이용하고
		// 반드시 out스트림을 생성하기 전에 선언해줘야 한다!!! 
		// 새로고침을 했는데 다운로드가 된다? test/html로 입력한건 아닌지 확인해보기
 		
		PrintWriter out = response.getWriter();
		// 브라우저와 서버 사이를 연결한 스트림을 생성
		
		// response 객체는 Writer라는 문자스트림 객체를 가지고 있음
		// 변수명은 반드시 out 으로
		// 왜 ? jsp에서 브라우저에 뭔가 출력할 때 사용하는 내장객체 out이 있으므로 지금부터 암기를 해야 함
		
		out.print("<html>");
		out.print("<body>");
		out.print("안녕하세요.");
		out.print("</body>");
		out.print("</html>");
		
		// 프로그램은 안전성, 신뢰성이 중요하기 때문에 반드시 <html>, <body>태그를 추가해야한다.
		// 기본 설정으로 출력할 때는 한글이 깨져서 나옴
		// 따라서 한글지원 처리를 해줘야 하는데, 반드시 out객체를 생성하기 전에 만들어야 한다. 
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
