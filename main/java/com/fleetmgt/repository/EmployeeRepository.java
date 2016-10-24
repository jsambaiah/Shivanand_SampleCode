/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fleetmgt.model.Employee;

/**
 * FleetManagementSystem - EmployeeRepository.java, Jul 7, 2015, 8:17:00 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
