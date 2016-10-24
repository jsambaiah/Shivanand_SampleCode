/**
 * 
 */
package com.fleetmgt.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * FleetManagementSystem - BasePojo.java, Jul 19, 2015, 9:39:34 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
public class BasePojo {
	@Id
	protected String id;
	protected Date createdDate;
	protected Date modifiedDate;
	protected String createdBy;
	protected String modifiedBy;
	protected Date effectiveDate;
	protected Date expiryDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "BasePojo [id=" + id + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", effectiveDate="
				+ effectiveDate + ", expiryDate=" + expiryDate + "]";
	}
	
	
	

}
