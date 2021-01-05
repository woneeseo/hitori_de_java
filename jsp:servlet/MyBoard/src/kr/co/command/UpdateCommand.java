package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String sNum = request.getParameter("num");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int num = Integer.parseInt(sNum);
		
		BoardDTO dto = new BoardDTO(num, author, title, content, null, -1, -1, -1, -1);
		
		new BoardDAO().update(dto);
		
		return new CommandAction(true, "read.do?num="+num);
	}

}
