/**
 * 
 */
package com.fleetmgt.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmgt.model.Customer;
import com.fleetmgt.service.CustomerService;

/**
 * FleetManagementSystem - CustomerRestController.java, Jul 14, 2015, 8:29:05 PM
 * 
 * @author <a href="mailto:shivuamalyal@gmail.com">Shivanand Amalyal</a>
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	//@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Customer> getAllCustomers(
			@RequestParam("fieldValuePair") String fieldValuePair,
			@RequestParam("fVSeparator") String fVSeparator,
			@RequestParam("fFSeperator") String fFSeperator,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortOrder") String sortOrder) {
		System.out
				.println("Inside controller get All Customers input params ::: fieldValuePair"
						+ fieldValuePair
						+ ":: fVSeparator"
						+ fVSeparator
						+ ":: fFSeperator:: "
						+ fFSeperator
						+ ":: sortField "
						+ sortField + " :: sortOrder" + sortOrder);
		return customerService.findAllCustomers(fieldValuePair, fVSeparator,
				fFSeperator, sortField, sortOrder);
	}

	
	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
	//@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Customer> getCustomers(
			@RequestParam("searchParam") String searchParam) {
		System.out
				.println("Inside controller get  Customers input params ::: searchParam"
						+ searchParam);
		return customerService.findCustomers(searchParam);
	}
	/**
	 * 
	 * If dirty is true it will not update the whole object instead updates only
	 * values which got changed.
	 * 
	 * @param id
	 * @param customer
	 * @param dirty
	 *//*
	//@PUT
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@Consumes({ MediaType.APPLICATION_JSON })
	//@RequestMapping("/{id}")
	//@RequestMapping(value = "/fetchDutyLogSheets", method = RequestMethod.GET)
	public void updateCustomer(
			@PathVariable(value = "id") String id,
			@RequestBody Customer customer,
			@PathParam(value = "dirty") boolean dirty) throws IllegalArgumentException{
		System.out.println("get customers!!! dirty ::" +dirty);

		Customer details4mDB = customerRepository.findOne(id);
		if(details4mDB != null)
		{
			if (dirty) {
				BeanUtilsBean notNull = new NullAwareBeanUtilsBean();
				Cloner cloner=new Cloner();
				try {
					notNull.copyProperties(details4mDB, customer);
					 //details4mDB = cloner.deepClone(customer);
					 System.out.println("::customer::" +customer +":::" +details4mDB);
					//cloner.copyPropertiesOfInheritedClass(customer, details4mDB);
					customerRepository.save(details4mDB);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				customerRepository.save(customer);
			}
		}else
		{
			throw new IllegalArgumentException();
		}
	}
*/
}
