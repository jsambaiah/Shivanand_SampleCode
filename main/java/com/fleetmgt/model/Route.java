/**
 * 
 */
package com.fleetmgt.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fleetmgt.common.CascadeSave;

/**
 * @author Shivanand Amalyal
 *
 */
@Document(collection = "ROUTE")
public class Route {
	@Id
	private String id;
	private String routeName;
	private String source;
	private String destination;
	private List<String> pickUpPoints;
	@DBRef
	@CascadeSave
	private List<Vehicle> vehicleList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<String> getPickUpPoints() {
		return pickUpPoints;
	}
	public void setPickUpPoints(List<String> pickUpPoints) {
		this.pickUpPoints = pickUpPoints;
	}
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	@Override
	public String toString() {
		return "Route [id=" + id + ", routeName=" + routeName + ", source="
				+ source + ", destination=" + destination + ", pickUpPoints="
				+ pickUpPoints + ", vehicleList=" + vehicleList + "]";
	}
	
}
