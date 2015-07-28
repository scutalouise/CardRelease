package com.sanploy.card.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_hairpin")
public class Hairpin implements Serializable {

	private static final long serialVersionUID = -5977976704954215922L;

	@Id
	@GeneratedValue(generator = "hairpinGenerator")
	@GenericGenerator(name = "hairpinGenerator", strategy = "assigned")
	@Column(length = 12)
	private String hairpinNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date hairpinTime;

	@Column(nullable = false, length = 8)
	private String cardPhysicalAdd;

	@Column(nullable = false, length = 6)
	private String cardNo;

	@Column(nullable = false, length = 20)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operateDate;

	public String getHairpinNo() {
		return hairpinNo;
	}

	public void setHairpinNo(String hairpinNo) {
		this.hairpinNo = hairpinNo;
	}

	public Date getHairpinTime() {
		return hairpinTime;
	}

	public void setHairpinTime(Date hairpinTime) {
		this.hairpinTime = hairpinTime;
	}

	public String getCardPhysicalAdd() {
		return cardPhysicalAdd;
	}

	public void setCardPhysicalAdd(String cardPhysicalAdd) {
		this.cardPhysicalAdd = cardPhysicalAdd;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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

	/**@Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月10日 上午10:11:15 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + ((cardPhysicalAdd == null) ? 0 : cardPhysicalAdd.hashCode());
		result = prime * result + ((hairpinNo == null) ? 0 : hairpinNo.hashCode());
		result = prime * result + ((hairpinTime == null) ? 0 : hairpinTime.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	/**@Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月10日 上午10:11:15 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hairpin other = (Hairpin) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (cardPhysicalAdd == null) {
			if (other.cardPhysicalAdd != null)
				return false;
		} else if (!cardPhysicalAdd.equals(other.cardPhysicalAdd))
			return false;
		if (hairpinNo == null) {
			if (other.hairpinNo != null)
				return false;
		} else if (!hairpinNo.equals(other.hairpinNo))
			return false;
		if (hairpinTime == null) {
			if (other.hairpinTime != null)
				return false;
		} else if (!hairpinTime.equals(other.hairpinTime))
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