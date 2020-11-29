package com.naver;

import java.io.Serializable;

public class DepartDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String dep;
	
	public DepartDTO() {
		// TODO Auto-generated constructor stub
	}

	public DepartDTO(String dep) {
		super();
		this.dep = dep;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DepartDTO [dep=" + dep + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dep == null) ? 0 : dep.hashCode());
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
		DepartDTO other = (DepartDTO) obj;
		if (dep == null) {
			if (other.dep != null)
				return false;
		} else if (!dep.equals(other.dep))
			return false;
		return true;
	}
	
	

}
