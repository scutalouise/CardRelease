package com.sanploy.card.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 7700312792685610664L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;

	@Column(nullable = false, length = 50)
	private String roleName;

	@Column(nullable = false, length = 1)
	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date setTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date validTime;

	@Column(nullable = true, length = 200)
	private String remark;

	@Column(nullable = false, length = 20)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operateDate;

	// @ManyToMany
	@OneToMany(targetEntity = RoleFunction.class, mappedBy = "role", cascade = CascadeType.ALL)
	private Collection<RoleFunction> roleFunctions = new ArrayList<RoleFunction>();

	/**
	 * @return the roleId
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the setTime
	 */
	public Date getSetTime() {
		return setTime;
	}

	/**
	 * @param setTime
	 *            the setTime to set
	 */
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	/**
	 * @return the validTime
	 */
	public Date getValidTime() {
		return validTime;
	}

	/**
	 * @param validTime
	 *            the validTime to set
	 */
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
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
	 * @param operateDate
	 *            the operateDate to set
	 */
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	/**
	 * @return the roleFunctions
	 */
	public Collection<RoleFunction> getRoleFunctions() {
		return roleFunctions;
	}

	/**
	 * @param roleFunctions
	 *            the roleFunctions to set
	 */
	public void setRoleFunctions(Collection<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月16日 下午1:38:53
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((roleFunctions == null) ? 0 : roleFunctions.hashCode());
		result = prime * result + (int) (roleId ^ (roleId >>> 32));
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((setTime == null) ? 0 : setTime.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((validTime == null) ? 0 : validTime.hashCode());
		return result;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月16日 下午1:38:53
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
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
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (roleFunctions == null) {
			if (other.roleFunctions != null)
				return false;
		} else if (!roleFunctions.equals(other.roleFunctions))
			return false;
		if (roleId != other.roleId)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (setTime == null) {
			if (other.setTime != null)
				return false;
		} else if (!setTime.equals(other.setTime))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (validTime == null) {
			if (other.validTime != null)
				return false;
		} else if (!validTime.equals(other.validTime))
			return false;
		return true;
	}

}