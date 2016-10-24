/**
 * 
 */
package com.fleetmgt.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmgt.model.TravelRequest;
import com.fleetmgt.service.TravelRequestService;

/**
 * @author Shivanand Amalyal
 *
 */
@RestController
@RequestMapping(value = "/travelRequests")
public class TravelRequestRestController {

	/*@Autowired
	private TravelRequestService  travelRequestService;
	@RequestMapping(value= "/createTravelRequest",method = RequestMethod.POST)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public void createTravelRequest(@RequestBody TravelRequest travelrequest)   {
		System.out.println("Inside controller createTravelRequest" +travelrequest.toString());
		//TravelRequest travelRequest=new TravelRequest();
		travelRequestService.createTravelRequest(travelrequest);
		//return getVehicles();
	}*/
}
