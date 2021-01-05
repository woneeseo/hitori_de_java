package kr.co.command;

import java.io.Serializable;

public class LoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}