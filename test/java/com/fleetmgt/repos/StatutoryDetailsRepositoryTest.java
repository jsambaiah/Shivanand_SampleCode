/**
 * 
 */
package com.fleetmgt.repos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.StatutoryDetails;
import com.fleetmgt.repository.StatutoryDetailsRepository;

/**
 * @author Shivanand Amalyal
 *
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class StatutoryDetailsRepositoryTest extends
		AbstractTestNGSpringContextTests {
	@Autowired
	StatutoryDetailsRepository StatutoryDetailsRepository;

	@Test
	public void createStatutoryDetails() {
		StatutoryDetails statutoryDetails = new StatutoryDetails();
		statutoryDetails.setInsuranceRenewalDate(new Date());
		statutoryDetails.setPermitRenewalDate(new Date());
		statutoryDetails.setPollutionRenewalDate(new Date());
		statutoryDetails.setDriverBadgeRenewalDate(new Date());
		statutoryDetails.setFitnessRenewalDate(new Date());
		StatutoryDetailsRepository.save(statutoryDetails);
	}

}
