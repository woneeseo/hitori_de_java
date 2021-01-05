package kr.co.ezen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HerServlet
 */

public class HerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/show.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		while(true) {
			String msg = br.readLine();
			if(msg == null) {
				break;
			}
			
			System.out.println(msg);
		}
		
		br.close();
		// in 의 close()를 호출하지 않는 이유?
		// api를 이용해서 전달받은 스트림은 close()를 호출해서는 안된다
		// api객체가 없어져버림
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
