package com.sanploy.card.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_dot")
public class Dot implements Serializable {

	private static final long serialVersionUID = 6099471171837412372L;

	@Id
	@GeneratedValue(generator = "dotGenerator")
	@GenericGenerator(name = "dotGenerator", strategy = "assigned")
	@Column(length = 20)
	private String dotId;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 100)
	private String address;

	@Column(nullable = false, length = 20)
	private String phone1;

	@Column(nullable = true, length = 20)
	private String phone2;

	@Column(nullable = true, length = 50)
	private String fax;

	@Column(nullable = true, length = 15)
	private String ip;

	@Column(nullable = false, length = 20)
	private String operator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date operateDate;

	@OneToMany(mappedBy = "dot", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.REFRESH })
	private Collection<TradePoint> tradePoints = new ArrayList<TradePoint>();

	public String getDotId() {
		return dotId;
	}

	public void setDotId(String dotId) {
		this.dotId = dotId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	/**
	 * @return the tradePoints
	 */
	public Collection<TradePoint> getTradePoints() {
		return tradePoints;
	}

	/**
	 * @param tradePoints
	 *            the tradePoints to set
	 */
	public void setTradePoints(Collection<TradePoint> tradePoints) {
		this.tradePoints = tradePoints;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#hashCode()
	 * @return
	 * @since:2015年7月16日 上午10:34:07
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dotId == null) ? 0 : dotId.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((operateDate == null) ? 0 : operateDate.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result + ((tradePoints == null) ? 0 : tradePoints.hashCode());
		return result;
	}

	/**
	 * @Description:
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 * @since:2015年7月16日 上午10:34:07
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dot other = (Dot) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dotId == null) {
			if (other.dotId != null)
				return false;
		} else if (!dotId.equals(other.dotId))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
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
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (tradePoints == null) {
			if (other.tradePoints != null)
				return false;
		} else if (!tradePoints.equals(other.tradePoints))
			return false;
		return true;
	}

}