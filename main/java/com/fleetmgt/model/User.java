/**
 * 
 */
package com.fleetmgt.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Shivanand Amalyal
 *
 */
// @Document(collection = "USER")
public class User extends BasePojo {
	
	@TextIndexed
	protected String name;
	protected String addressLine1;
	protected String addressLine2;
	protected String contactNo;
	@TextIndexed
	protected String city;
	protected String zipCode;
	// private String pickupPoint;
	/**
	 * unique field of user
	 */
	// @Indexed(unique=true)
	private String userId;

	/*
	 * @DBRef private Customer customer;
	 */
	/*
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id; }
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/*
	 * public String getPickupPoint() { return pickupPoint; }
	 * 
	 * public void setPickupPoint(String pickupPoint) { this.pickupPoint =
	 * pickupPoint; }
	 */

	/*
	 * public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 * 
	 * 
	 * public String getUserId() { return userId; }
	 * 
	 * public void setUserId(String userId) { this.userId = userId; }
	 */

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", contactNo=" + contactNo
				+ ", city=" + city + ", zipCode=" + zipCode + ", userId="
				+ userId + ", id=" + id + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", effectiveDate="
				+ effectiveDate + ", expiryDate=" + expiryDate + "]";
	}

	

}
