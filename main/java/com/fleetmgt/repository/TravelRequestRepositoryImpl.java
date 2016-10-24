/**
 * 
 */
package com.fleetmgt.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.fleetmgt.model.TravelRequest;

/**
 * @author Shivanand Amalyal
 *
 */
public class TravelRequestRepositoryImpl implements
		TravelRequestRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;


	@Override
	public List<TravelRequest> findApprovedTravelRequests(Query query) {

		return mongoTemplate.find(query,TravelRequest.class);
	}

}
