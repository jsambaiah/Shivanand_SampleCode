/**
 * 
 */
package com.fleetmgt.controller;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fleetmgt.model.InternalBillingReports;

/**
 * FleetManagementSystem - InternalBillingReportsController.java, Jul 21, 2015, 11:35:58 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
public interface InternalBillingReportsController  extends
PagingAndSortingRepository<InternalBillingReports, String>{

}
