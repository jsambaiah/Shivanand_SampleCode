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
 * @author Shivanand Amalyal
 *
 */
@Document(collection = "CUSTOMER")
public class Customer extends User{

	@Id
	private String id;
	private String location;
	private Boolean travelRequestAutoApproval;

	@CascadeSave
	@DBRef
	private List<Employee>employees;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getTravelRequestAutoApproval() {
		return travelRequestAutoApproval;
	}

	public void setTravelRequestAutoApproval(Boolean travelRequestAutoApproval) {
		this.travelRequestAutoApproval = travelRequestAutoApproval;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", location=" + location
				+ ", travelRequestAutoApproval=" + travelRequestAutoApproval
				+ ", employees=" + employees + ", name=" + name
				+ ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", contactNo=" + contactNo + ", city=" + city
				+ ", zipCode=" + zipCode + "]";
	}

	

	

}
