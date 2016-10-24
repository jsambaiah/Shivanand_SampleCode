/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.fleetmgt.model.Package;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface PackageRepository extends
		MongoRepository<Package, String> {

}
