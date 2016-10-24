/**
 * 
 */
package com.fleetmgt.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.fleetmgt.model.Customer;

/**
 * FleetManagementSystem - CustomerRepositoryImpl.java, Jul 13, 2015, 11:42:44 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
public class CustomerRepositoryImpl implements CustomerRepositoryCustom{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Customer> findCustomers(Query query) {
		System.out.println("Query inside CustomerRepositoryImpl ::" +query);
		 return mongoTemplate.find(query,Customer.class);
	}

}
