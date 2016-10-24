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
 * FleetManagementSystem - FleetServiceProvider.java, Jul 4, 2015, 6:11:39 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Document(collection = "FLEET_SERVICE_PROVIDER")
public class FleetServiceProvider extends User {
	@Id
	private String id;

	@CascadeSave
	@DBRef
	private List<Customer> customers;

	@CascadeSave
	@DBRef
	private List<Vendor> vendors;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	@Override
	public String toString() {
		return "FleetServiceProvider [id=" + id + ", customers=" + customers
				+ ", vendors=" + vendors + ", name=" + name + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2
				+ ", contactNo=" + contactNo + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}

}
