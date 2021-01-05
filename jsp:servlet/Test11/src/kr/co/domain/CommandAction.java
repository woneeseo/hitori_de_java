package kr.co.domain;

public class CommandAction {
	
	// 포워딩과 관련된 정보를 가지고있는 클래스 
	
	// 1. 어떤 방식으로 포워딩 할것인지?
	// 2. 어디로 포워딩을 시킬것인지?

	private boolean isRedirect;
	// 포워딩 방식이 Redirect 방식인가? true - Redirect로
	// 							  false - dispatcher방식으로 포워딩 할 것임
	private String where;
	// 어디로 포워딩 할 것인지를 나타냄

	public CommandAction() {
		// TODO Auto-generated constructor stub
	}

	public CommandAction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

}
