/**
 * 
 */
package com.fleetmgt.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Vendor;
import com.fleetmgt.repository.VendorRepository;

/**
 * FleetManagementSystem - VendorRepositoryTest.java, Jul 9, 2015, 12:43:11 AM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
	@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
	public class VendorRepositoryTest extends AbstractTestNGSpringContextTests {
		@Autowired
		VendorRepository vendorRepository;

		@Test
		public void createVendor() {
			Vendor vendor = new Vendor();
			vendor.setName("Zabbar Travels");
			vendor.setAddressLine1("KR Puram");
			vendor.setCity("Bangalore");
			vendor.setContactNo("1234");
			vendorRepository.save(vendor);
		}
}