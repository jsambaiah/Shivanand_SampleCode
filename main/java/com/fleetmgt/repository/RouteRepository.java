/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.Route;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface RouteRepository extends MongoRepository<Route, String>{

}
