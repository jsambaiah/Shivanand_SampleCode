package com.fleetmgt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmgt.exception.ResourceNotFoundException;
import com.fleetmgt.model.Vehicle;

/**
 * @author Shivanand Amalyal
 *
 */
@RestController
@RequestMapping(value = "/orders")
public class VehicleRestController {
	//@Autowired
	//private VehicleService vehicleService;
	public VehicleRestController(){
		System.out.println("Constructor:::");
	}

	// TODO -methods can be written for implementing any operationsST
	@RequestMapping(method = RequestMethod.GET)
	public Vehicle getVehicle() throws ResourceNotFoundException  {
		// simulate Manager/DAO call:
		throw new ResourceNotFoundException("throwing exception");
		//return getVehicles();
	}

	/*
	 * @GET public void getVehicle() throws ResourceNotFoundException{ throw new
	 * ResourceNotFoundException("throwing exception"); }
	 */

	private Vehicle getVehicles() throws ResourceNotFoundException {
		throw new ResourceNotFoundException("throwing exception");
	}

}