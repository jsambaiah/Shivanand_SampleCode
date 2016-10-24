/**
 * 
 */
package com.fleetmgt.service;

import com.fleetmgt.model.User;

/**
 * @author Shivanand Amalyal
 *
 */
public interface UserService {
	public User findByName(String name);	
}
