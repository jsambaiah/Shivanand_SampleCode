/**
 * 
 */
package com.fleetmgt.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.fleetmgt.model.TravelRequest;

/**
 * @author Shivanand Amalyal
 *
 */
public interface TravelRequestRepositoryCustom {
	public List<TravelRequest>findApprovedTravelRequests(Query query);
}
