/**
 * 
 */
package com.fleetmgt.service;

import java.util.List;

import com.fleetmgt.model.Customer;
import com.fleetmgt.model.TravelRequest;

/**
 * FleetManagementSystem - Customer.java, Jul 5, 2015, 11:40:35 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
public interface CustomerService {
	public List<Customer> findAllCustomers(String fieldValuePair,
			String fVSeparator, String fFSeperator, String sortField,
			String sortOrder);

	public List<Customer> findCustomers(String searchParam);

}
