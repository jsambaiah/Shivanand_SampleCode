/**
 * 
 */
package com.fleetmgt.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Route;
import com.fleetmgt.model.Vehicle;
import com.fleetmgt.repository.RouteRepository;

/**
 * @author Shivanand Amalyal
 *
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class RouteRepositoryTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private RouteRepository routeRepository;

	@Test
	public void createCustomerConfiguration() {
		Route route = new Route();
		route.setRouteName("Koramangala-MTW");
		route.setSource("Koramangala");
		route.setDestination("MindTree-Global Village");
		List<String> pickUpPoints=new ArrayList<String>();
		pickUpPoints.add("Majestic");
		pickUpPoints.add("Sirsi circle");
		route.setPickUpPoints(pickUpPoints);
		List<Vehicle>vehicleList=new ArrayList<Vehicle>();
		Vehicle vehicle=new Vehicle();
		vehicle.setRegNo("AP-1234");
		Vehicle vehicle1=new Vehicle();
		vehicle1.setRegNo("KA-28_F345");
		vehicleList.add(vehicle);
		vehicleList.add(vehicle1);
		route.setVehicleList(vehicleList);
		routeRepository.save(route);
	}

}
