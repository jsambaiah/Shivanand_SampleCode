/**
 * 
 */
package com.fleetmgt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.User;
import com.fleetmgt.model.Vehicle;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
