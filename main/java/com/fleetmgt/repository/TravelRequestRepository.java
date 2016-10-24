/**
 * 
 */
package com.fleetmgt.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.TravelRequest;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface TravelRequestRepository extends
		MongoRepository<TravelRequest, String>, TravelRequestRepositoryCustom {
}
