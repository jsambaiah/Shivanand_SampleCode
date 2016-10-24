/**
 * 
 */
package com.fleetmgt.controller;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fleetmgt.model.StatutoryDetails;

/**
 * @author Shivanand Amalyal
 *
 */
@EnableWebMvc
@RepositoryRestResource
public interface StatutoryDetailsController extends  PagingAndSortingRepository<StatutoryDetails, String>{

}
