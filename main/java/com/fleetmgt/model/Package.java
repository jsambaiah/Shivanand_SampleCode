/**
 * 
 */
package com.fleetmgt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Shivanand Amalyal
 *
 */
@Document(collection = "PACKAGE")
public class Package  extends BasePojo{
	@Id
	private String id;

	public  String packageType;
	
	public  String vehicleType;

	private Double price ;
	
	private String unit ;
	
	private PackageLimits packageLimits;
	
	private PackageAdditionalCharges packageAdditionalCharges;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the packageType
	 */
	public String getPackageType() {
		return packageType;
	}

	/**
	 * @param packageType the packageType to set
	 */
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the packageLimits
	 */
	public PackageLimits getPackageLimits() {
		return packageLimits;
	}

	/**
	 * @param packageLimits the packageLimits to set
	 */
	public void setPackageLimits(PackageLimits packageLimits) {
		this.packageLimits = packageLimits;
	}

	/**
	 * @return the packageAdditionalCharges
	 */
	public PackageAdditionalCharges getPackageAdditionalCharges() {
		return packageAdditionalCharges;
	}

	/**
	 * @param packageAdditionalCharges the packageAdditionalCharges to set
	 */
	public void setPackageAdditionalCharges(
			PackageAdditionalCharges packageAdditionalCharges) {
		this.packageAdditionalCharges = packageAdditionalCharges;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Package [id=" + id + ", packageType=" + packageType
				+ ", vehicleType=" + vehicleType + ", price=" + price
				+ ", unit=" + unit + ", packageLimits=" + packageLimits
				+ ", packageAdditionalCharges=" + packageAdditionalCharges
				+ ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", effectiveDate=" + effectiveDate
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	

	
	

}
