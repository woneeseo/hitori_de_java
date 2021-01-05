package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		
		// DB에서 가져온 데이터를 바인딩 해서 jsp에 뿌려줘야함.
		
		return new CommandAction(false, "list.jsp");
	}

}
