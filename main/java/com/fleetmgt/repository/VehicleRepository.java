package com.fleetmgt.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.Vehicle;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String>
{
	public Vehicle findByRegNo(@Param("regNo") String regNo);
}