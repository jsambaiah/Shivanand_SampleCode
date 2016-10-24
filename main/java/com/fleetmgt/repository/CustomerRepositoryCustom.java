/**
 * 
 */
package com.fleetmgt.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.fleetmgt.model.Customer;

/**
 * FleetManagementSystem - CustomerRepositoryCustom.java, Jul 13, 2015, 11:41:15 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
public interface CustomerRepositoryCustom {

	public List<Customer>findCustomers(Query query);
}
