package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// updateCommand는 insertCommand와 유사하게 
		// update.jsp로부터 입력받은 값을 getParameter()로 가지고 와서 
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		// 수정과정을 거쳐
		int age = Integer.parseInt(sAge);
		
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		// 입력받은 정보를 가진 dto객체를 생성해 낸 뒤,
		
		dao.update(dto);
		// dao의 update()에 dto객체를 파라미터로 넣어서 sql문을 처리할 수 있도록 함
		
		return new CommandAction(true, "read.do?id="+id);
		// 수정이 완료되면 read.do로 이동하도록 함
		// 수정이 완료되어서 read.do로 페이지가 이동했음에도 불구하고 servlet path가 여전이 update.do이면 이상함
		// + 바인딩 된 객체가 없다 : 수정 후 화면에 정보를 출력하는 것은 read.do에서 해줄 것 : 포워딩 방식은 redirect
		
		// "read.do?id="+id -> 수정한 아이디를 기반으로 그 아이디에 해당하는 회원정보 자세히 보기로 가야하므로
		// 포워딩 할 주소 뒤에 받은 id 값을 넣어 정확한 주소로 갈 수 있도록 한다
		// 회원 id가 m001인 사람이 정보 수정을 완료 버튼을 누른 뒤, read.do로 페이지를 이동하면
		// servlet path는 		read.do?id=m001 	를 나타낸다.
	}

}
