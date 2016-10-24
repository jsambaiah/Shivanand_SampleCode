/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.FleetServiceProvider;

/**
 * FleetManagementSystem - FleetServiceProviderRepository.java, Jul 9, 2015, 12:41:29 AM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Repository
public interface FleetServiceProviderRepository extends MongoRepository<FleetServiceProvider, String>{

}
