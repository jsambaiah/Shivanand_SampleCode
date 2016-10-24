/**
 * 
 */
package com.fleetmgt.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * FleetManagementSystem - InternalBillingReports.java, Jul 21, 2015, 11:10:12 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Document(collection="INTERNAL_BILLING_REPORT")
public class InternalBillingReports extends BasePojo{
	private Vehicle vehicle;
	private Package packages;
	private List<Expense> expenses;
	private Vendor vendor;
	private TravelLog travelLog;
	/**
	 * has to be clarified
	 */
	private Integer dieselInLts;
	private Double total;
	private Double deductedAmount;
	private Double grandTotal;
	private Double paidAmount;
	private String chequeNo;
	private String voucherNo;
	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * @return the packages
	 */
	public Package getPackages() {
		return packages;
	}
	/**
	 * @param packages the packages to set
	 */
	public void setPackages(Package packages) {
		this.packages = packages;
	}
	
	
	/**
	 * @return the expenses
	 */
	public List<Expense> getExpenses() {
		return expenses;
	}
	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	/**
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	/**
	 * @return the dieselInLts
	 */
	public Integer getDieselInLts() {
		return dieselInLts;
	}
	/**
	 * @param dieselInLts the dieselInLts to set
	 */
	public void setDieselInLts(Integer dieselInLts) {
		this.dieselInLts = dieselInLts;
	}
	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * @return the deductedAmount
	 */
	public Double getDeductedAmount() {
		return deductedAmount;
	}
	/**
	 * @param deductedAmount the deductedAmount to set
	 */
	public void setDeductedAmount(Double deductedAmount) {
		this.deductedAmount = deductedAmount;
	}
	/**
	 * @return the grandTotal
	 */
	public Double getGrandTotal() {
		return grandTotal;
	}
	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	/**
	 * @return the paidAmount
	 */
	public Double getPaidAmount() {
		return paidAmount;
	}
	/**
	 * @param paidAmount the paidAmount to set
	 */
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	/**
	 * @return the chequeNo
	 */
	public String getChequeNo() {
		return chequeNo;
	}
	/**
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	/**
	 * @return the voucherNo
	 */
	public String getVoucherNo() {
		return voucherNo;
	}
	/**
	 * @param voucherNo the voucherNo to set
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	
	/**
	 * @return the travelLog
	 */
	public TravelLog getTravelLog() {
		return travelLog;
	}
	/**
	 * @param travelLog the travelLog to set
	 */
	public void setTravelLog(TravelLog travelLog) {
		this.travelLog = travelLog;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InternalBillingReports [vehicle=" + vehicle + ", packages="
				+ packages + ", expenses=" + expenses + ", vendor=" + vendor
				+ ", travelLog=" + travelLog + ", dieselInLts=" + dieselInLts
				+ ", total=" + total + ", deductedAmount=" + deductedAmount
				+ ", grandTotal=" + grandTotal + ", paidAmount=" + paidAmount
				+ ", chequeNo=" + chequeNo + ", voucherNo=" + voucherNo + "]";
	}
	
	
	
	
}
