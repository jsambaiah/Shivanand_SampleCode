/**
 * 
 */
package com.fleetmgt.controller;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fleetmgt.model.Employee;

/**
 * FleetManagementSystem - EmployeeController.java, Jul 7, 2015, 8:14:37 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@EnableWebMvc
@RepositoryRestResource
public interface EmployeeController extends PagingAndSortingRepository<Employee, String> {

}
