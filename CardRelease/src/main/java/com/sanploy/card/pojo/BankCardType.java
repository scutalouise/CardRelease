package com.sanploy.card.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_bankCardType")
public class BankCardType implements Serializable{

	private static final long serialVersionUID = -8792546261456467290L;

	@Id
	@GeneratedValue(generator = "bankCardTypeGenerator")
	@GenericGenerator(name = "bankCardTypeGenerator", strategy = "assigned")
	@Column(length = 2)
	private String bankCardTypeId;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false, length = 20)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private java.util.Date operateDate;

	public String getBankCardTypeId() {
		return bankCardTypeId;
	}

	public void setBankCardTypeId(String bankCardTypeId) {
		this.bankCardTypeId = bankCardTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public java.util.Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	}

	/**@Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月10日 上午10:12:40 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCardTypeId == null) ? 0 : bankCardTypeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	/**@Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月10日 上午10:12:40 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankCardType other = (BankCardType) obj;
		if (bankCardTypeId == null) {
			if (other.bankCardTypeId != null)
				return false;
		} else if (!bankCardTypeId.equals(other.bankCardTypeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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