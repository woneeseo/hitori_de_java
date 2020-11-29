package com.naver;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String dep;
	private int tel;
	private static int TEL_LENGTH = 11;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(String id, String name, String dep, int tel) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
		this.tel = tel;
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

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public static int getTEL_LENGTH() {
		return TEL_LENGTH;
	}

	public static void setTEL_LENGTH(int tEL_LENGTH) {
		TEL_LENGTH = tEL_LENGTH;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return id + " " + name + " ("+ dep + ") " + "tel. "+tel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
