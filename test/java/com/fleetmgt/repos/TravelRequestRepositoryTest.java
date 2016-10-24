/**
 * 
 */
package com.fleetmgt.repos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.TravelRequest;
import com.fleetmgt.model.User;
import com.fleetmgt.repository.TravelRequestRepository;
import com.fleetmgt.service.TravelRequestService;


/**
 * @author Shivanand Amalyal
 *
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml"})
public class TravelRequestRepositoryTest extends AbstractTestNGSpringContextTests{
	
	
		
		/*@Autowired
		private TravelRequestRepository travelRequestRepository;
		//private TravelRequestService travelRequestService;
		
		@Test
		public void createTravelRequest()
		{
			TravelRequest travelRequest=new TravelRequest();
			travelRequest.setPickUpPoint("Vijay Nagar");
			travelRequest.setDropOffPoint("MTW");
			travelRequest.setStartDate(new Date());
			travelRequest.setEndDate(new Date());
			travelRequest.setPickUpTime(new Date());
			travelRequest.setDropOffTime(new Date());
			travelRequest.setRoundTrip(true);
			//travelRequest.setStatus("APPROVED");
			User user=new User();
			user.setId("5586da45cb04aca92c9a5609");
			System.out.println("user created with Id ::" +user.getId());
			//user.setId("xxxx");
			travelRequest.setUser(user);
			travelRequestRepository.save(travelRequest);
			//travelRequestService.createTravelRequest(travelRequest);
		}
*/
}
