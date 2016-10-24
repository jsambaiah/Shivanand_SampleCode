package com.fleetmgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmgt.model.Vehicle;
import com.fleetmgt.repository.VehicleRepository;

/**
 * @author Shivanand Amalyal
 *
 */
@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle getVehilceByRegNo(String regNo) {
		return vehicleRepository.findByRegNo(regNo);
	}

}