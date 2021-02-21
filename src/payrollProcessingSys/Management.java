package payrollProcessingSys;

import java.text.DecimalFormat;

/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	private double bonus;
	private boolean mnger;
	private boolean dpthd;
	private boolean drctr;
	
	/**
	@param
	*/
	public Management(Profile eProfile, double thePay, double annSalary, double theBonus) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay, annSalary);
		this.bonus = theBonus;
	}
	
	/**
	@return 
	*/
	public double getBonus() {
		return bonus;
	}
	
	/**
	@param 
	*/
	public void setBonus(double theBonus) {
		this.bonus = theBonus;
	}
	
	/**
	@return
	*/
	public String getTheBonus() {
		String theBonus = "";
		return theBonus = new DecimalFormat("$##,###.##").format(bonus);
	}
	
	/**
	@return
	*/
	public boolean getMnger() { 
		return mnger;
	}
	
	/**
	@return 
	*/
	public boolean getDpthd() {
		return dpthd;
	}
	
	/**
	@return 
	*/
	public boolean getDrctr() {
		return drctr;
	}
	
	/**
	@param 
	*/
	public void setMnger(boolean mnger) { 
		this.mnger = mnger;
	}
	
	/**
	@param
	*/
	public void setDpthd(boolean dpthd) {
		this.dpthd = dpthd;
	}
	
	/**
	@param
	*/
	public void setDrctr(boolean drctr) {
		this.drctr = drctr;
	}
	
	/** 
	According to the given role number, calculates the earning for the pay period
	*/
	@Override
	public void calculatePayment() { 
		double managercomp = 5000; //1 additional compensation annually
		double deptheadcomp = 9500; //2 aditional compensation annually
		double directorcomp = 12000; //3 additional compensation annually
		int manager = 1;
		int deptHead = 2;
		int director = 3;
		double thePay = super.getPaid();
		double annSalary = super.getAnnualSalary();
		int totalPayPeriods = super.getFTPayPeriods();
		int payCounter = 0;
		for(int i=0; i <= director; i++) { //each index of array represents a managerial role
			if(i == manager) {
				if(payCounter != totalPayPeriods) { //too ensure we cannot have more than 26 pay periods in year
					if(bonus <= managercomp) { //additional comp for specific role for each pay period cannot be more than total annual
						thePay = (annSalary/ totalPayPeriods) + bonus; 
						managercomp = managercomp - bonus; //after managerial employee paid part of add comp, what they can be paid for the rest of the year decrements by how much they were paid 
						payCounter++;	
					}
				}
			}else if(i == deptHead) {
				if(payCounter != totalPayPeriods) {
					if(bonus <= deptheadcomp) {
						thePay = (annSalary/ totalPayPeriods) + bonus; 
						deptheadcomp = deptheadcomp - bonus;
						payCounter++;
					}
				}
			}else {
				if(payCounter != totalPayPeriods) {
					if(bonus <= directorcomp) {
						thePay = (annSalary/ totalPayPeriods) + bonus;
						directorcomp = directorcomp - bonus;
						payCounter++;	
					}	
				}
			}
		}	
	}
	
	/**
	@return
	*/
	@Override
	public String toString() { 
		String roleOutput = "";
		if(getMnger() == true) {
			roleOutput = super.toString() + "::Manager Compensation " + getTheBonus();
		}else if(getDpthd() == true) {
			roleOutput = super.toString() + "::Director Compensation " + getTheBonus();
		}else if(getDrctr() == true) {
			roleOutput = super.toString() + "::DepartmentHead Compensation " + getTheBonus();
		}
		return roleOutput;
	}
	
	/**
	@param
	@return
	*/
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Management) {
			return super.equals(obj) && bonus == ((Management) obj).bonus;
		}
		return false;
	}

}
