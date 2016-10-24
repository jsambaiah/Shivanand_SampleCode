/**
 * 
 */
package com.fleetmgt.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fleetmgt.common.CascadeSave;

/**
 * @author Shivanand Amalyal
 *
 */
@Document(collection = "DRIVER")
public class Driver {

	@Id
	private String id;
	private String name;
	private String vehicleNo;
	private String licenseNo;
	private String badgeNo;
	private String badgeRenewalNo;
	/**
	 * upload doc for ID proof
	 */
	private byte[] identificationNo;
	private String policeVerificationNo;;
	private String insurancePolicyNo;
	/**
	 * upload doc for address proof
	 */
	private byte[] address;
	private Double salary;
	@DBRef
	@CascadeSave
	private List<Vehicle> vehicleList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getBadgeNo() {
		return badgeNo;
	}

	public void setBadgeNo(String badgeNo) {
		this.badgeNo = badgeNo;
	}

	public String getBadgeRenewalNo() {
		return badgeRenewalNo;
	}

	public void setBadgeRenewalNo(String badgeRenewalNo) {
		this.badgeRenewalNo = badgeRenewalNo;
	}

	public byte[] getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(byte[] identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getPoliceVerificationNo() {
		return policeVerificationNo;
	}

	public void setPoliceVerificationNo(String policeVerificationNo) {
		this.policeVerificationNo = policeVerificationNo;
	}

	public String getInsurancePolicyNo() {
		return insurancePolicyNo;
	}

	public void setInsurancePolicyNo(String insurancePolicyNo) {
		this.insurancePolicyNo = insurancePolicyNo;
	}

	public byte[] getAddress() {
		return address;
	}

	public void setAddress(byte[] address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", vehicleNo="
				+ vehicleNo + ", licenseNo=" + licenseNo + ", badgeNo="
				+ badgeNo + ", badgeRenewalNo=" + badgeRenewalNo
				+ ", identificationNo=" + Arrays.toString(identificationNo)
				+ ", policeVerificationNo=" + policeVerificationNo
				+ ", insurancePolicyNo=" + insurancePolicyNo + ", address="
				+ Arrays.toString(address) + ", salary=" + salary
				+ ", vehicleList=" + vehicleList + "]";
	}

}
