package com.sanploy.card.pojo;

import java.io.Serializable;

public class RoleFunctionPK implements Serializable {

	private static final long serialVersionUID = 7656885868207465782L;

	public RoleFunctionPK() {
		super();
	}

	public RoleFunctionPK(Role role, Function function) {
		super();
		this.role = role;
		this.function = function;
	}


//	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH,CascadeType.MERGE})
//	@JoinColumn(name = "roleId")
	private Role role;

//	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH,CascadeType.MERGE})
//	@JoinColumn(name = "functionId")
	private Function function;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		RoleFunctionPK other = (RoleFunctionPK) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

}
