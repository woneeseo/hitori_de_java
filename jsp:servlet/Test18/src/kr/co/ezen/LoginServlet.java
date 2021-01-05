package kr.co.ezen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		int age = Integer.parseInt(pw);

		LoginDTO loginDTO = new LoginDTO();
		
		loginDTO.setId(id);
		loginDTO.setAge(age);
		
		MemberDAO dao = new MemberDAO();
		LoginDTO newDTO = dao.login(loginDTO);
		
		HttpSession session = request.getSession();
		session.setAttribute("newDTO", newDTO);
		// 세션을 사용할 곳은 이곳
		
		// session은 request객체를 이용해 선언해준다
		// getSession() or getSession(true) : session이 있으면 있는 것을 넘겨주고, 
		// session이 없으면, 새로 만들어서 넘겨주어라 (파라미터가 true인 메서드와 파라미터가 없는 메서드의 기능은 동일하다.
		// 로그인에서는 getSesstion()이나 getSession(true)를 사용한다.
		
		// getSesstion(false) : session이 있을 때만 넘겨주고, 없으면 null을 넘겨준다.
		// 인증이 된 상태에서 이용하는 기능들 (ex.계좌이체등..) 은 세션이 있을 때만 진행할 수 있도록 getSesstion(false)를 사용한다
		
		
		
		
	}

}
