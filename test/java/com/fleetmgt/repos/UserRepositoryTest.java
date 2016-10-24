/**
 * 
 */
package com.fleetmgt.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Customer;
import com.fleetmgt.model.User;
import com.fleetmgt.repository.UserRepository;

/**
 * @author Shivanand Amalyal
 *
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class UserRepositoryTest extends AbstractTestNGSpringContextTests {
	
	/*@Autowired
	private UserRepository userRepository;*/

	/*@Test
	public void createCustomerConfiguration() {
		User user=new User();
		user.setName("Shivanand");
		user.setAddress("Indira nagar");
		user.setPhoneNo("7845694904");
		user.setPickupPoint("IndiraNagar");
		List<String> roles=new ArrayList<String>();
		user.setUserId("M1016296");
		roles.add("Employee");
		user.setRoles(roles);
		Customer customer=new Customer();
		System.out.println("customer created");
		customer.setId("55904c43822abd648d60141f");
		System.out.println("customer created with Id ::" +customer.getId());
		user.setCustomer(customer);
		System.out.println("User created with Id ::" +user.toString());
		userRepository.save(user);
		
	}*/

}
