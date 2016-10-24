/**
 * 
 */
package com.fleetmgt.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Shivanand Amalyal
 *
 */
@Document(collection = "TRAVEL_REQUEST")
public class TravelRequest {
	@Id
	private String id;
	private String pickUpPoint;
	private String dropOffPoint;
	private Date startDate;
	private Date endDate;
	private Date pickUpTime;
	private Date dropOffTime;
	private String status;
	private Boolean roundTrip;

	@DBRef
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPickUpPoint() {
		return pickUpPoint;
	}

	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}

	public String getDropOffPoint() {
		return dropOffPoint;
	}

	public void setDropOffPoint(String dropOffPoint) {
		this.dropOffPoint = dropOffPoint;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public Date getDropOffTime() {
		return dropOffTime;
	}

	public void setDropOffTime(Date dropOffTime) {
		this.dropOffTime = dropOffTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Boolean getRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(Boolean roundTrip) {
		this.roundTrip = roundTrip;
	}

	@Override
	public String toString() {
		return "TravelRequest [id=" + id + ", pickUpPoint=" + pickUpPoint
				+ ", dropOffPoint=" + dropOffPoint + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", pickUpTime=" + pickUpTime
				+ ", dropOffTime=" + dropOffTime + ", status=" + status
				+ ", roundTrip=" + roundTrip + ", user=" + user + "]";
	}

	

}
