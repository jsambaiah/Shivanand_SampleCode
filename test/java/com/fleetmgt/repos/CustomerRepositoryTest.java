/**
 * 
 */
package com.fleetmgt.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Customer;
import com.fleetmgt.repository.CustomerRepository;

/**
 * @author Shivanand Amalyal
 *
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class CustomerRepositoryTest extends AbstractTestNGSpringContextTests {
	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void createCustomer() {
		Customer customer = new Customer();
		customer.setName("MindTree");
		customer.setTravelRequestAutoApproval(true);
		customer.setAddressLine1("Global Village");
		customer.setCity("Bangalore");
		customer.setContactNo("7845694904");
		customerRepository.save(customer);
	}

}
