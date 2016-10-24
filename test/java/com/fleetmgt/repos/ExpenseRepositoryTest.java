/**
 * 
 */
package com.fleetmgt.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.fleetmgt.model.Expense;
import com.fleetmgt.repository.ExpenseRepository;

/**
 * @author Shivanand Amalyal
 *
 */
@ContextConfiguration(locations = { "classpath:spring-db-test.xml" })
public class ExpenseRepositoryTest  extends AbstractTestNGSpringContextTests{
	@Autowired
	ExpenseRepository expenseReository;

	@Test
	public void createExpense() {
		Expense expense=new Expense();
		expense.setDieselExpense(1200.00);
		expense.setMiscellaneousExpense(25000.00);
		expense.setCabExpense(12000.00);
		expense.setAdvanceEntry(25000.00);
		expenseReository.save(expense);
	}

}