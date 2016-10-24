/**
 * 
 */
package com.fleetmgt.controller;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fleetmgt.exception.ResourceNotFoundException;
import com.fleetmgt.model.Customer;
import com.fleetmgt.model.Vehicle;

/**
 * @author Shivanand Amalyal
 *
 */
@EnableWebMvc
@RepositoryRestResource
public interface CustomerController extends
		PagingAndSortingRepository<Customer, String> {

	//List<Vehicle> findByQuery(@Param("name") String name) throws ResourceNotFoundException;
	
	List<Vehicle> findByName(@Param("name") String name);
	
}
