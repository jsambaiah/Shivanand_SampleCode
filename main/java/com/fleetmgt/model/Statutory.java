/**
 * 
 */
package com.fleetmgt.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Shivanand Amalyal
 *
 */
@Document(collection = "STATUTORY")
public class Statutory {
	@Id
	private String id;
	private String type;
	private Date startDate;
	private Date endDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Statutory [id=" + id + ", type=" + type + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

}
