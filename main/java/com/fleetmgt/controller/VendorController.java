/**
 * 
 */
package com.fleetmgt.controller;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fleetmgt.model.Vendor;

/**
 * FleetManagementSystem - VendorController.java, Jul 8, 2015, 8:57:16 PM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@EnableWebMvc
@RepositoryRestResource
public interface VendorController extends PagingAndSortingRepository<Vendor, String>{

}
