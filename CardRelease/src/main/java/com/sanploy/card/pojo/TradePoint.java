package com.sanploy.card.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_tradePoint")
public class TradePoint implements Serializable {

	private static final long serialVersionUID = -5408177445862590255L;

	@Id
	@GeneratedValue(generator = "tradePointGenerator")
	@GenericGenerator(name = "tradePointGenerator", strategy = "assigned")
	@Column(length = 12)
	private String tradePointNo;

	@Column(nullable = false, length = 1)
	private String tradeType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date tradeDate;

	@Column(nullable = false, length = 6)
	private String cardNo;

	@Column(nullable = false, length = 4)
	private String ptBefore;

	@Column(nullable = false, length = 4)
	private String ptAfter;

	@Column(nullable = false, length = 4)
	private String ptTrade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operateDate;

	@Column(nullable = false, length = 20)
	private String operator;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "bankCardNo")
	private Customer customer;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "dotId")
	private Dot dot;

	public String getTradePointNo() {
		return tradePointNo;
	}

	public void setTradePointNo(String tradePointNo) {
		this.tradePointNo = tradePointNo;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPtBefore() {
		return ptBefore;
	}

	public void setPtBefore(String ptBefore) {
		this.ptBefore = ptBefore;
	}

	public String getPtAfter() {
		return ptAfter;
	}

	public void setPtAfter(String ptAfter) {
		this.ptAfter = ptAfter;
	}

	public String getPtTrade() {
		return ptTrade;
	}

	public void setPtTrade(String ptTrade) {
		this.ptTrade = ptTrade;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the dot
	 */
	public Dot getDot() {
		return dot;
	}

	/**
	 * @param dot
	 *            the dot to set
	 */
	public void setDot(Dot dot) {
		this.dot = dot;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月16日 上午10:32:08
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dot == null) ? 0 : dot.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((ptAfter == null) ? 0 : ptAfter.hashCode());
		result = prime * result + ((ptBefore == null) ? 0 : ptBefore.hashCode());
		result = prime * result + ((ptTrade == null) ? 0 : ptTrade.hashCode());
		result = prime * result + ((tradeDate == null) ? 0 : tradeDate.hashCode());
		result = prime * result + ((tradePointNo == null) ? 0 : tradePointNo.hashCode());
		result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
		return result;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月16日 上午10:32:08
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradePoint other = (TradePoint) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dot == null) {
			if (other.dot != null)
				return false;
		} else if (!dot.equals(other.dot))
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
		if (ptAfter == null) {
			if (other.ptAfter != null)
				return false;
		} else if (!ptAfter.equals(other.ptAfter))
			return false;
		if (ptBefore == null) {
			if (other.ptBefore != null)
				return false;
		} else if (!ptBefore.equals(other.ptBefore))
			return false;
		if (ptTrade == null) {
			if (other.ptTrade != null)
				return false;
		} else if (!ptTrade.equals(other.ptTrade))
			return false;
		if (tradeDate == null) {
			if (other.tradeDate != null)
				return false;
		} else if (!tradeDate.equals(other.tradeDate))
			return false;
		if (tradePointNo == null) {
			if (other.tradePointNo != null)
				return false;
		} else if (!tradePointNo.equals(other.tradePointNo))
			return false;
		if (tradeType == null) {
			if (other.tradeType != null)
				return false;
		} else if (!tradeType.equals(other.tradeType))
			return false;
		return true;
	}

}