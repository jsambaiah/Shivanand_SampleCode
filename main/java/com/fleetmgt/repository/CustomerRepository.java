/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.Customer;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>,CustomerRepositoryCustom {

}
