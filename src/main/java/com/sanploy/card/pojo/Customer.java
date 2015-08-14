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
@Table(name = "t_customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 2005977061117145650L;

	@Id
	@GeneratedValue(generator = "customerGenerator")
	@GenericGenerator(name = "customerGenerator", strategy = "assigned")
	@Column(length = 30)
	private String bankCardNo;

	@Column(nullable = false, length = 6)
	private String cardNo;

	@Column(nullable = false, length = 24)
	private String customerName;

	@Column(nullable = false, length = 20)
	private String customerTel;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date invalid;

	@Column(nullable = false, length = 4)
	private String originalPt;

	@Column(nullable = false, length = 4)
	private String remainingPt;

	@Column(nullable = false, length = 1)
	private String loss;

	@Column(nullable = false, length = 24)
	private String hairpinDot;

	@Column(nullable = false, length = 4)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operateDate;

	@JoinColumn(name = "bankCardTypeId")
	@OneToOne(optional = false)
	private BankCardType bankCardType;

	/**
	 * @return the bankCardNo
	 */
	public String getBankCardNo() {
		return bankCardNo;
	}

	/**
	 * @param bankCardNo
	 *            the bankCardNo to set
	 */
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo
	 *            the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerTel
	 */
	public String getCustomerTel() {
		return customerTel;
	}

	/**
	 * @param customerTel
	 *            the customerTel to set
	 */
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	/**
	 * @return the invalid
	 */
	public Date getInvalid() {
		return invalid;
	}

	/**
	 * @param invalid
	 *            the invalid to set
	 */
	public void setInvalid(Date invalid) {
		this.invalid = invalid;
	}

	/**
	 * @return the originalPt
	 */
	public String getOriginalPt() {
		return originalPt;
	}

	/**
	 * @param originalPt
	 *            the originalPt to set
	 */
	public void setOriginalPt(String originalPt) {
		this.originalPt = originalPt;
	}

	/**
	 * @return the remainingPt
	 */
	public String getRemainingPt() {
		return remainingPt;
	}

	/**
	 * @param remainingPt
	 *            the remainingPt to set
	 */
	public void setRemainingPt(String remainingPt) {
		this.remainingPt = remainingPt;
	}

	/**
	 * @return the loss
	 */
	public String getLoss() {
		return loss;
	}

	/**
	 * @param loss
	 *            the loss to set
	 */
	public void setLoss(String loss) {
		this.loss = loss;
	}

	/**
	 * @return the hairpinDot
	 */
	public String getHairpinDot() {
		return hairpinDot;
	}

	/**
	 * @param hairpinDot
	 *            the hairpinDot to set
	 */
	public void setHairpinDot(String hairpinDot) {
		this.hairpinDot = hairpinDot;
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
	 * @return the bankCardType
	 */
	public BankCardType getBankCardType() {
		return bankCardType;
	}

	/**
	 * @param bankCardType
	 *            the bankCardType to set
	 */
	public void setBankCardType(BankCardType bankCardType) {
		this.bankCardType = bankCardType;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月27日 下午1:16:56
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCardNo == null) ? 0 : bankCardNo.hashCode());
		result = prime * result + ((bankCardType == null) ? 0 : bankCardType.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerTel == null) ? 0 : customerTel.hashCode());
		result = prime * result + ((hairpinDot == null) ? 0 : hairpinDot.hashCode());
		result = prime * result + ((invalid == null) ? 0 : invalid.hashCode());
		result = prime * result + ((loss == null) ? 0 : loss.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((originalPt == null) ? 0 : originalPt.hashCode());
		result = prime * result + ((remainingPt == null) ? 0 : remainingPt.hashCode());
		return result;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月27日 下午1:16:56
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (bankCardNo == null) {
			if (other.bankCardNo != null)
				return false;
		} else if (!bankCardNo.equals(other.bankCardNo))
			return false;
		if (bankCardType == null) {
			if (other.bankCardType != null)
				return false;
		} else if (!bankCardType.equals(other.bankCardType))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerTel == null) {
			if (other.customerTel != null)
				return false;
		} else if (!customerTel.equals(other.customerTel))
			return false;
		if (hairpinDot == null) {
			if (other.hairpinDot != null)
				return false;
		} else if (!hairpinDot.equals(other.hairpinDot))
			return false;
		if (invalid == null) {
			if (other.invalid != null)
				return false;
		} else if (!invalid.equals(other.invalid))
			return false;
		if (loss == null) {
			if (other.loss != null)
				return false;
		} else if (!loss.equals(other.loss))
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
		if (originalPt == null) {
			if (other.originalPt != null)
				return false;
		} else if (!originalPt.equals(other.originalPt))
			return false;
		if (remainingPt == null) {
			if (other.remainingPt != null)
				return false;
		} else if (!remainingPt.equals(other.remainingPt))
			return false;
		return true;
	}

}