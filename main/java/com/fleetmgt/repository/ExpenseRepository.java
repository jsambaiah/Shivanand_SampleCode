/**
 * 
 */
package com.fleetmgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fleetmgt.model.Expense;

/**
 * @author Shivanand Amalyal
 *
 */
@Repository
public interface ExpenseRepository extends MongoRepository<Expense,String>{

}
