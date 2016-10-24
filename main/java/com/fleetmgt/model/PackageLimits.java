/**
 * 
 */
package com.fleetmgt.model;

/**
 * FleetManagementSystem - PackageLimits.java, Jul 21, 2015, 8:18:13 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
public class PackageLimits {
	private Double distanceInKm;
	private Double timeInHours;
	private String week;
	private Integer numDays;
	private String tripType;
	/**
	 * @return the distanceInKm
	 */
	public Double getDistanceInKm() {
		return distanceInKm;
	}
	/**
	 * @param distanceInKm the distanceInKm to set
	 */
	public void setDistanceInKm(Double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	/**
	 * @return the timeInHours
	 */
	public Double getTimeInHours() {
		return timeInHours;
	}
	/**
	 * @param timeInHours the timeInHours to set
	 */
	public void setTimeInHours(Double timeInHours) {
		this.timeInHours = timeInHours;
	}
	/**
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * @return the numDays
	 */
	public Integer getNumDays() {
		return numDays;
	}
	/**
	 * @param numDays the numDays to set
	 */
	public void setNumDays(Integer numDays) {
		this.numDays = numDays;
	}
	/**
	 * @return the tripType
	 */
	public String getTripType() {
		return tripType;
	}
	/**
	 * @param tripType the tripType to set
	 */
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackageLimits [distanceInKm=" + distanceInKm + ", timeInHours="
				+ timeInHours + ", week=" + week + ", numDays=" + numDays
				+ ", tripType=" + tripType + "]";
	}
	
	
	

}
