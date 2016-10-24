/**
 * 
 */
package com.fleetmgt.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fleetmgt.common.CascadeSave;

/**
 * FleetManagementSystem - Vendor.java, Jul 8, 2015, 8:51:03 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Document(collection = "VENDOR")
public class Vendor extends User {
	@Id
	private String id;
	private String panNo;

	@CascadeSave
	@DBRef
	private List<Vehicle> vehicles;
	@CascadeSave
	@DBRef
	private List<Package> packages;

	public String getId() {
		return id;
	}
	

	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}


	/**
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}


	public void setId(String id) {
		this.id = id;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", vehicles=" + vehicles + ", packages="
				+ packages + ", name=" + name + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2
				+ ", contactNo=" + contactNo + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}

}
