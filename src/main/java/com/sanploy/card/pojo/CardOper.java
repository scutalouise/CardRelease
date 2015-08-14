package com.sanploy.card.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_cardOper")
public class CardOper implements Serializable {

	private static final long serialVersionUID = 6323531811888549251L;

	@Id
	@GeneratedValue(generator = "cardOperGenerator")
	@GenericGenerator(name = "cardOperGenerator", strategy = "assigned")
	@Column(length = 12)
	private String operNo;

	@Column(length = 1, nullable = false)
	private String operType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date operDate;

	@Column(length = 6, nullable = false)
	private String oldCardNo;
	
	@Column(length = 6, nullable = true)
	private String newCardNo;

	@Column(length = 4, nullable = false)
	private String remainingPt;

	@OneToOne(optional = false)
	@JoinColumn(name = "dotId", nullable = false)
	private Dot dot;

	@Column(length = 20, nullable = false)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date operateDate;

	/**
	 * @return the operNo
	 */
	public String getOperNo() {
		return operNo;
	}

	/**
	 * @param operNo the operNo to set
	 */
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}

	/**
	 * @return the operType
	 */
	public String getOperType() {
		return operType;
	}

	/**
	 * @param operType the operType to set
	 */
	public void setOperType(String operType) {
		this.operType = operType;
	}

	/**
	 * @return the operDate
	 */
	public Date getOperDate() {
		return operDate;
	}

	/**
	 * @param operDate the operDate to set
	 */
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	/**
	 * @return the oldCardNo
	 */
	public String getOldCardNo() {
		return oldCardNo;
	}

	/**
	 * @param oldCardNo the oldCardNo to set
	 */
	public void setOldCardNo(String oldCardNo) {
		this.oldCardNo = oldCardNo;
	}

	/**
	 * @return the newCardNo
	 */
	public String getNewCardNo() {
		return newCardNo;
	}

	/**
	 * @param newCardNo the newCardNo to set
	 */
	public void setNewCardNo(String newCardNo) {
		this.newCardNo = newCardNo;
	}

	/**
	 * @return the remainingPt
	 */
	public String getRemainingPt() {
		return remainingPt;
	}

	/**
	 * @param remainingPt the remainingPt to set
	 */
	public void setRemainingPt(String remainingPt) {
		this.remainingPt = remainingPt;
	}

	/**
	 * @return the dot
	 */
	public Dot getDot() {
		return dot;
	}

	/**
	 * @param dot the dot to set
	 */
	public void setDot(Dot dot) {
		this.dot = dot;
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
	 * @since:2015年7月28日 上午10:35:19 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dot == null) ? 0 : dot.hashCode());
		result = prime * result + ((newCardNo == null) ? 0 : newCardNo.hashCode());
		result = prime * result + ((oldCardNo == null) ? 0 : oldCardNo.hashCode());
		result = prime * result + ((operDate == null) ? 0 : operDate.hashCode());
		result = prime * result + ((operNo == null) ? 0 : operNo.hashCode());
		result = prime * result + ((operType == null) ? 0 : operType.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((remainingPt == null) ? 0 : remainingPt.hashCode());
		return result;
	}

	/**@Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月28日 上午10:35:19 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardOper other = (CardOper) obj;
		if (dot == null) {
			if (other.dot != null)
				return false;
		} else if (!dot.equals(other.dot))
			return false;
		if (newCardNo == null) {
			if (other.newCardNo != null)
				return false;
		} else if (!newCardNo.equals(other.newCardNo))
			return false;
		if (oldCardNo == null) {
			if (other.oldCardNo != null)
				return false;
		} else if (!oldCardNo.equals(other.oldCardNo))
			return false;
		if (operDate == null) {
			if (other.operDate != null)
				return false;
		} else if (!operDate.equals(other.operDate))
			return false;
		if (operNo == null) {
			if (other.operNo != null)
				return false;
		} else if (!operNo.equals(other.operNo))
			return false;
		if (operType == null) {
			if (other.operType != null)
				return false;
		} else if (!operType.equals(other.operType))
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
		if (remainingPt == null) {
			if (other.remainingPt != null)
				return false;
		} else if (!remainingPt.equals(other.remainingPt))
			return false;
		return true;
	}


}
