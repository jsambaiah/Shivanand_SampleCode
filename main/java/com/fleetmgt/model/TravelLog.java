/**
 * 
 */
package com.fleetmgt.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fleetmgt.common.CascadeSave;

/**
 * FleetManagementSystem - TravelLog.java, Jul 18, 2015, 11:34:06 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Document(collection = "TRAVEL_LOG")
public class TravelLog {
	@Id
	private String id;
	private String sheetNo;
	private Date travelDate;
	/**
	 * To be discussed - Driver can be a new pojo and relation [one to many or
	 * many to one]
	 */
	@DBRef
	private Driver driver;
	@DBRef
	private Vehicle vehicle;
	@DBRef
	@CascadeSave
	private List<EmployeeTravelLog> employeeTravelLogList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSheetNo() {
		return sheetNo;
	}

	public void setSheetNo(String sheetNo) {
		this.sheetNo = sheetNo;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<EmployeeTravelLog> getEmployeeTravelLogList() {
		return employeeTravelLogList;
	}

	public void setEmployeeTravelLogList(
			List<EmployeeTravelLog> employeeTravelLogList) {
		this.employeeTravelLogList = employeeTravelLogList;
	}

	@Override
	public String toString() {
		return "TravelLog [id=" + id + ", sheetNo=" + sheetNo + ", travelDate="
				+ travelDate + ", driver=" + driver + ", vehicle=" + vehicle
				+ ", employeeTravelLogList=" + employeeTravelLogList + "]";
	}

}
