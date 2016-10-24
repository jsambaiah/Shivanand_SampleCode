/**
 * 
 */
package com.fleetmgt.repos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Employee;
import com.fleetmgt.repository.EmployeeRepository;

/**
 * FleetManagementSystem - EmployeeRepositoryTest.java, Jul 7, 2015, 8:22:51 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class EmployeeRepositoryTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void createEmployee() {
		Employee employee=new Employee();
		employee.setName("Shivanand");
		employee.setPickUpPoint("Kengeri");
		employee.setAddressLine1("Kengeri");
		employee.setShift("9-6");
		employee.setContactNo("7845694902");
		employeeRepository.save(employee);
		
	}

}
