/**
 * 
 */
package com.fleetmgt.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmgt.model.PackageType;

/**
 * FleetManagementSystem - PackageTypeServiceImpl.java, Jul 7, 2015, 12:06:51 AM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@Component
public class PackageTypeServiceImpl implements PackageTypeService {

	private static final Logger LOGGER = Logger
			.getLogger(PackageTypeServiceImpl.class);
	//@Autowired
	private PackageType packageType;

	@Override
	public List<PackageType> getAllPackageTypes() {
		// TODO Auto-generated method stub
		return PackageType.getAllPackageTypes();
	}

}
