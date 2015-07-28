package com.sanploy.card.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_role_function")
@IdClass(RoleFunctionPK.class)
public class RoleFunction implements Serializable {

	private static final long serialVersionUID = -7360629386258077907L;

	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "roleId")
	private Role role;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "functionId")
	private Function function;

	@Column(nullable = false, length = 20)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operateDate;

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the function
	 */
	public Function getFunction() {
		return function;
	}

	/**
	 * @param function the function to set
	 */
	public void setFunction(Function function) {
		this.function = function;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the operateDate
	 */
	public Date getOperateDate() {
		return operateDate;
	}

	/**
	 * @param operateDate the operateDate to set
	 */
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	/**@Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月16日 下午2:24:28 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	/**@Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月16日 下午2:24:28 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleFunction other = (RoleFunction) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (operateDate == null) {
			if (other.operateDate != null)
				return false;
		} else if (!operateDate.equals(other.operateDate))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
	


}