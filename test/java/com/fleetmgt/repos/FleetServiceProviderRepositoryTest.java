/**
 * 
 */
package com.fleetmgt.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.FleetServiceProvider;
import com.fleetmgt.repository.FleetServiceProviderRepository;

/**
 * FleetManagementSystem - FleetServiceProviderRepository.java, Jul 9, 2015,
 * 8:30:00 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class FleetServiceProviderRepositoryTest extends
		AbstractTestNGSpringContextTests {
	@Autowired
	FleetServiceProviderRepository fleetServiceProviderRepository;

	@Test
	public void createCustomer() {
		FleetServiceProvider fleetServiceProvider = new FleetServiceProvider();
		fleetServiceProvider.setName("Abburi travels");
		fleetServiceProvider.setAddressLine1("Hyderabad");
		fleetServiceProviderRepository.save(fleetServiceProvider);

	}

}
