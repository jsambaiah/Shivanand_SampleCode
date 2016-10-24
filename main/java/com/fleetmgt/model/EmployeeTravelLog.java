/**
 * 
 */
package com.fleetmgt.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * FleetManagementSystem - EmployeeTravelLog.java, Jul 18, 2015, 11:38:04 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Document(collection = "EMPLOYEE_TRAVEL_LOG")
public class EmployeeTravelLog {
	@Id
	private String id;
	private String pickupLocation;
	private String dropLocation;
	private Date pickupTime;
	private Date dropTime;
	private Double startKm;
	private Double endKm;
	private Double totalTimeInMins;
	private Double totalKms;
	@DBRef
	private Employee employee;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	public Date getDropTime() {
		return dropTime;
	}
	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}
	public Double getStartKm() {
		return startKm;
	}
	public void setStartKm(Double startKm) {
		this.startKm = startKm;
	}
	public Double getEndKm() {
		return endKm;
	}
	public void setEndKm(Double endKm) {
		this.endKm = endKm;
	}
	public Double getTotalTimeInMins() {
		return totalTimeInMins;
	}
	public void setTotalTimeInMins(Double totalTimeInMins) {
		this.totalTimeInMins = totalTimeInMins;
	}
	public Double getTotalKms() {
		return totalKms;
	}
	public void setTotalKms(Double totalKms) {
		this.totalKms = totalKms;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
