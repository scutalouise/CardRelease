package com.sanploy.card.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "t_kdlimit")
public class KDLimit implements Serializable {

	private static final long serialVersionUID = 8288206207706960133L;

	@Id
	@GeneratedValue(generator = "kdlimitGenerator")
	@GenericGenerator(name = "kdlimitGenerator", strategy = "assigned")
	@Column(length = 10)
	private String limitNo;

	@Column(nullable = false, length = 50)
	private String limitName;

	@Column(nullable = false, length = 2)
	private String limitPoint;

	@Column(nullable = false, length = 20)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operateDate;

	@OneToOne(cascade = CascadeType.REFRESH, targetEntity = BankCardType.class)
	@JoinColumn(name = "bankCardTypeId")
	private BankCardType bankCardType;

	public String getLimitNo() {
		return limitNo;
	}

	public void setLimitNo(String limitNo) {
		this.limitNo = limitNo;
	}

	public String getLimitName() {
		return limitName;
	}

	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}

	public String getLimitPoint() {
		return limitPoint;
	}

	public void setLimitPoint(String limitPoint) {
		this.limitPoint = limitPoint;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public BankCardType getBankCardType() {
		return bankCardType;
	}

	public void setBankCardType(BankCardType bankCardType) {
		this.bankCardType = bankCardType;
	}

	/**@Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月10日 上午10:11:05 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((limitName == null) ? 0 : limitName.hashCode());
		result = prime * result + ((limitNo == null) ? 0 : limitNo.hashCode());
		result = prime * result + ((limitPoint == null) ? 0 : limitPoint.hashCode());
		result = prime * result + ((bankCardType == null) ? 0 : bankCardType.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	/**@Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月10日 上午10:11:05 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KDLimit other = (KDLimit) obj;
		if (limitName == null) {
			if (other.limitName != null)
				return false;
		} else if (!limitName.equals(other.limitName))
			return false;
		if (limitNo == null) {
			if (other.limitNo != null)
				return false;
		} else if (!limitNo.equals(other.limitNo))
			return false;
		if (limitPoint == null) {
			if (other.limitPoint != null)
				return false;
		} else if (!limitPoint.equals(other.limitPoint))
			return false;
		if (bankCardType == null) {
			if (other.bankCardType != null)
				return false;
		} else if (!bankCardType.equals(other.bankCardType))
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
		return true;
	}
}
