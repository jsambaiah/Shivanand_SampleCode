/**
 * 
 */
package com.fleetmgt.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * FleetManagementSystem - Employee.java, Jul 7, 2015, 12:23:10 AM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Document(collection = "EMPLOYEE")
public class Employee extends User {
	@Id
	private String id;
	private String employeeId;
	private String pickUpPoint;
	private String shift;
	private String middleName;
	private String lastName;
	private String gender;
	private String mobileNo;
	private String alternativeMobileNo;
	private String primayEmailId;
	private String secondayEmailId;
	private byte [] photo;
	protected String adharNo;
	protected String location;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPickUpPoint() {
		return pickUpPoint;
	}
	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAlternativeMobileNo() {
		return alternativeMobileNo;
	}
	public void setAlternativeMobileNo(String alternativeMobileNo) {
		this.alternativeMobileNo = alternativeMobileNo;
	}
	public String getPrimayEmailId() {
		return primayEmailId;
	}
	public void setPrimayEmailId(String primayEmailId) {
		this.primayEmailId = primayEmailId;
	}
	public String getSecondayEmailId() {
		return secondayEmailId;
	}
	public void setSecondayEmailId(String secondayEmailId) {
		this.secondayEmailId = secondayEmailId;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeId=" + employeeId
				+ ", pickUpPoint=" + pickUpPoint + ", shift=" + shift
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", gender=" + gender + ", mobileNo=" + mobileNo
				+ ", alternativeMobileNo=" + alternativeMobileNo
				+ ", primayEmailId=" + primayEmailId + ", secondayEmailId="
				+ secondayEmailId + ", photo=" + Arrays.toString(photo)
				+ ", adharNo=" + adharNo + ", location=" + location + ", name="
				+ name + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", contactNo=" + contactNo + ", city=" + city
				+ ", zipCode=" + zipCode + "]";
	}
	
	
	

}
