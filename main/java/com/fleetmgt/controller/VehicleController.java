package com.fleetmgt.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fleetmgt.exception.ResourceNotFoundException;
import com.fleetmgt.model.Vehicle;

/**
 * @author Shivanand Amalyal
 *
 */
@EnableWebMvc
@RepositoryRestResource
public interface VehicleController extends PagingAndSortingRepository<Vehicle, String>
{
	List<Vehicle> findByRegNo(@Param("customerName") String customerName);
	
}
