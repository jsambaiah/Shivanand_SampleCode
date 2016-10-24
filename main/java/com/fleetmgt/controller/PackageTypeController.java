/**
 * 
 */
package com.fleetmgt.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmgt.model.PackageType;
import com.fleetmgt.service.PackageTypeService;
import com.fleetmgt.service.TravelRequestService;

/**
 * FleetManagementSystem - PackageTypeController.java, Jul 7, 2015, 12:00:32 AM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@RestController
@RequestMapping(value = "/packageTypes")
public class PackageTypeController {
@Autowired
private PackageTypeService packageTypeService;

@RequestMapping(method = RequestMethod.GET)
@Produces({ MediaType.APPLICATION_JSON })
public List<PackageType> getAllPackageTypes()   {
	System.out.println("Inside controller packageTypeService");
	//TravelRequest travelRequest=new TravelRequest();
	return packageTypeService.getAllPackageTypes();
	//return getVehicles();
}

}
