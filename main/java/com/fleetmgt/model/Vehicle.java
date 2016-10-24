/**
 * 
 */
package com.fleetmgt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fleetmgt.common.CascadeSave;

/**
 * @author Shivanand Amalyal
 *
 */
@Document(collection = "VEHICLE")
public class Vehicle implements Serializable {
	@Id
	private String id;
	private String regNo;
	private String policeVerificationNo;
	private Date yearOfManifacture;
	
	private String vehicleType;
	//@Unique
	private String chassisNo;
	/**
	 * no of seats 
	 */
	private Integer occupancy;
	private Boolean ac;

	@DBRef
	@CascadeSave
	private List<Statutory> statutoryList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getPoliceVerificationNo() {
		return policeVerificationNo;
	}

	public void setPoliceVerificationNo(String policeVerificationNo) {
		this.policeVerificationNo = policeVerificationNo;
	}

	public Date getYearOfManifacture() {
		return yearOfManifacture;
	}

	public void setYearOfManifacture(Date yearOfManifacture) {
		this.yearOfManifacture = yearOfManifacture;
	}

	

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	
	public Integer getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(Integer occupancy) {
		this.occupancy = occupancy;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", regNo=" + regNo
				+ ", policeVerificationNo=" + policeVerificationNo
				+ ", yearOfManifacture=" + yearOfManifacture
				+ ", permitEndDate=" + permitEndDate + ", fitnessEndDate="
				+ fitnessEndDate + ", insuranceEndDate=" + insuranceEndDate
				+ ", vehicleType=" + vehicleType + ", ownerName=" + ownerName
				+ ", panNo=" + panNo + ", phoneNo=" + phoneNo + ", address="
				+ address + ", occupancy=" + occupancy + ", logBookEntry="
				+ logBookEntry + ", regVerified=" + regVerified
				+ ", routeList=" + routeList + "]";
	}

	

}
