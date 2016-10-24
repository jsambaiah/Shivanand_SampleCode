/**
 * 
 */
package com.fleetmgt.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmgt.exception.RestExceptionHandler;
import com.fleetmgt.model.Customer;
import com.fleetmgt.model.TravelRequest;
import com.fleetmgt.model.User;
import com.fleetmgt.repository.TravelRequestRepository;

/**
 * @author Shivanand Amalyal
 *
 */
/*@Component
public class TravelRequestServiceImpl implements TravelRequestService {
	private static final Logger LOGGER = Logger
			.getLogger(TravelRequestServiceImpl.class);

	@Autowired
	private TravelRequestRepository travelRequestRepository;

	@Override
	public void createTravelRequest(TravelRequest travelRequest) {
		LOGGER.info("Inside createTravelRequest method travelRequest"
				+ travelRequest.toString());
		User user = travelRequest.getUser();
		if (null != user) {
			LOGGER.info("User  ::" + user.toString());
			Customer customer = user.getCustomer();
			if (null != customer) {

				LOGGER.info("Customer ::" + customer.toString());
				if (customer.isTravelRequestAutoApproved()) {
					travelRequest.setStatus("APPROVED");
					//Logic PNR
				} else {
					travelRequest.setStatus("NEW");
				}
				LOGGER.info("TravelRequest ::" + travelRequest.toString());
				insertTravelRequest(travelRequest);
				// if(travelRequest)
			} else {
				LOGGER.info("TravelRequest for the cutsomer is not auto approved ::");
			}
		}

	}

	private void insertTravelRequest(TravelRequest travelRequest) {
		LOGGER.info("Inside insertTravelRequest method ");
		travelRequestRepository.save(travelRequest);

	}

}
*/