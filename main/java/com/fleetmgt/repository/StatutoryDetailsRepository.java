/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.StatutoryDetails;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface StatutoryDetailsRepository extends
		MongoRepository<StatutoryDetails, String> {

}
