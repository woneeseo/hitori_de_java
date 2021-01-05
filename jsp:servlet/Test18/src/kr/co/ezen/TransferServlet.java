package kr.co.ezen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("login.jsp");
			return;
			// 만약 session이 null이면 로그인화면으로 돌아간 뒤 return
		}
		// session　이 있으면 넘겨주고 없으면 null 이다.
		LoginDTO login = (LoginDTO) session.getAttribute("newDTO");
		// 세션 트래킹 없이 리퀘스트만으로 로그인을 하는 경우
		// 하나의 요청과 응답이 완료되면 서버와의 통신이 끊어진다.
		// 따라서 로그인을 했음에도 불구하고, http프로토콜의 비연결성 특징 때문에 로그인 기록이 사라져버리게 된다
		// 그렇기 때문에, 세션이 없이 로그인 작업을 계속해서 하면, 끊임없이 재로그인을 해야한다.
		// 인증 자체가 되지 않음 : 이것을 보완하기 위해서 session을 공부해야 한다
		// session : 인증을 거치는 모든 프로그램은 session을 거쳐야 한다.
		if(login != null) {
			System.out.println("계좌이체 작업을 합니다.");
		} else { 
			response.sendRedirect("login.jsp");
			System.out.println("로그인을 해 주세요.");
			
			// 로그인이 null인 경우 : 비밀번호나 아이디를 잘못 입력해 DB에서 가져올 수 없는 경우
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
