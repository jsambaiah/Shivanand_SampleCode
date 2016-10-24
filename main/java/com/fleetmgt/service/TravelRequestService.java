/**
 * 
 */
package com.fleetmgt.service;

import org.springframework.stereotype.Component;

import com.fleetmgt.model.TravelRequest;

/**
 * @author Shivanand Amalyal
 *
 */
@Component
public interface TravelRequestService {
	
	public void createTravelRequest(TravelRequest travelRequest);

}
