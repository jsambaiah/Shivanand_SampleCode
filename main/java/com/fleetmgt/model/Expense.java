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
@Document(collection = "EXPENSE")
public class Expense {
	@Id
	private String id;
	private Double dieselExpense;
	private Double miscellaneousExpense;
	private Double cabExpense;
	private Double advanceEntry;
	private Double TDS;
	
	public Double getTDS() {
		return TDS;
	}
	public void setTDS(Double tDS) {
		TDS = tDS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getDieselExpense() {
		return dieselExpense;
	}
	public void setDieselExpense(Double dieselExpense) {
		this.dieselExpense = dieselExpense;
	}
	public Double getMiscellaneousExpense() {
		return miscellaneousExpense;
	}
	public void setMiscellaneousExpense(Double miscellaneousExpense) {
		this.miscellaneousExpense = miscellaneousExpense;
	}
	public Double getCabExpense() {
		return cabExpense;
	}
	public void setCabExpense(Double cabExpense) {
		this.cabExpense = cabExpense;
	}
	public Double getAdvanceEntry() {
		return advanceEntry;
	}
	public void setAdvanceEntry(Double advanceEntry) {
		this.advanceEntry = advanceEntry;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", dieselExpense=" + dieselExpense
				+ ", miscellaneousExpense=" + miscellaneousExpense
				+ ", cabExpense=" + cabExpense + ", advanceEntry="
				+ advanceEntry + "]";
	}
	

}
