/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.Vendor;

/**
 * FleetManagementSystem - VendorRepository.java, Jul 9, 2015, 12:40:27 AM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Repository
public interface VendorRepository extends MongoRepository<Vendor, String>{

}
