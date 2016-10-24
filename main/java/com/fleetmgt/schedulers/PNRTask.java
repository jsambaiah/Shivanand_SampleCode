/**
 * 
 */
package com.fleetmgt.schedulers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fleetmgt.model.TravelRequest;
import com.fleetmgt.repository.TravelRequestRepository;

/**
 * @author Shivanand Amalyal
 *
 */
public class PNRTask {
	public static final String TR_STATUS="APPROVED";
	@Autowired
	private TravelRequestRepository travelRequestRepository;

	void printTask() {
		System.out.println("Printing the  PNR Task " + (new Date()));
		Query query=new Query();
		query.addCriteria(Criteria.where("status").is(TR_STATUS));
		List<TravelRequest> travelRequests = travelRequestRepository.findApprovedTravelRequests(query);
		System.out.println("TR size ::"+travelRequests.size());
	}
}
