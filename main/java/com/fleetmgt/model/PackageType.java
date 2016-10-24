/**
 * 
 */
package com.fleetmgt.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * FleetManagementSystem - PackageType.java, Jul 4, 2015, 11:51:46 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
//@Component
public enum PackageType {
	GENERAL, MMTS, ADHOC;
	
	 PackageType(){
		
	}
	/*public static PackageType getEnum(Integer id){
		PackageType.values();
		for(PackageType p:PackageType.values()){
			if(p.getId()==id){
				return p;
			}
		}
		return null;
	}*/
	public static List<PackageType> getAllPackageTypes(){
		
		List<PackageType>packageTypeList=new ArrayList<PackageType>();
		for(PackageType p:PackageType.values()){
			packageTypeList.add(p);
		}
		return packageTypeList;
		
	}
	public static void main(String[] args) {
		System.out.println("::" +PackageType.getAllPackageTypes());
	}
	
}
