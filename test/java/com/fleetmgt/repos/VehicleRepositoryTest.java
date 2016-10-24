package com.fleetmgt.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Route;
import com.fleetmgt.model.Vehicle;
import com.fleetmgt.repository.VehicleRepository;

@ContextConfiguration(locations = { "classpath:spring-db-test.xml"})
public class VehicleRepositoryTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Test
	public void createVehicle()
	{
		Vehicle vehicle = new Vehicle();
		vehicle.setRegNo("KA-28_F345");
		vehicle.setPoliceVerificationNo("PNO891");
		Route route= new Route();
		route.setRouteName("MTW-Majestic");
		route.setSource("MTW");
		List<Route>routeList=new ArrayList<Route>();
		routeList.add(route);
		vehicle.setRouteList(routeList);
		vehicleRepository.save(vehicle);
	}
}