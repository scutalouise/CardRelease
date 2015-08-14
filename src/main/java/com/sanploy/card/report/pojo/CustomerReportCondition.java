package com.sanploy.card.report.pojo;

public class CustomerReportCondition {

	private String startDate;

	private String endDate;

	private String customerName;

	private String customerReportType;

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	 * @return the customerReportType
	 */
	public String getCustomerReportType() {
		return customerReportType;
	}

	/**
	 * @param customerReportType
	 *            the customerReportType to set
	 */
	public void setCustomerReportType(String customerReportType) {
		this.customerReportType = customerReportType;
	}

}
