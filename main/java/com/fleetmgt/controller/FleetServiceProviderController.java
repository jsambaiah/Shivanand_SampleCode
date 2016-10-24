/**
 * 
 */
package com.fleetmgt.controller;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fleetmgt.model.FleetServiceProvider;

/**
 * FleetManagementSystem - FleetServiceProviderController.java, Jul 9, 2015, 12:38:31 AM
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@EnableWebMvc
@RepositoryRestResource
public interface FleetServiceProviderController extends PagingAndSortingRepository<FleetServiceProvider, String> {

}
