/**
 * 
 */
package com.fleetmgt.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Package;
import com.fleetmgt.repository.PackageRepository;

/**
 * @author Shivanand Amalyal
 *
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class PackageReositoryTest  extends AbstractTestNGSpringContextTests{
	@Autowired
	PackageRepository packageReository;

	@Test
	public void createPackage() {
		Package packages=new Package();
		packages.setPackageType("Monthly");
		packages.setPackageAmount(25000.00);
		packageReository.save(packages);
	}

}
