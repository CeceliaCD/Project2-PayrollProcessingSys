package payrollProcessingSys;

import java.text.DecimalFormat;

/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	
	private double bonus;
	private int role;
	private int manager = 1;
	private int deptHead = 2;
	private int director = 3;
	
	/**
	@param
	*/
	public Management(Profile eProfile, double thePay, double annSalary, int theRole, double theBonus) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay, annSalary);
		this.role = theRole;
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
	public int getRole() { 
		return role;
	}
	
	/**
	@param
	*/
	public void setRole(int theRole) {
		this.role = theRole;
	}
	
	/** 
	According to the given role number, calculates the earning for the pay period
	*/
	@Override
	public void calculatePayment() { 
		double managercomp = 5000.00; //1 additional compensation annually
		double deptheadcomp = 9500.00; //2 aditional compensation annually
		double directorcomp = 12000.00; //3 additional compensation annually
		double thePay = super.getPaid();
		double annSalary = super.getAnnualSalary();
		int totalPayPeriods = super.getFTPayPeriods();
		int payCounter = 0;
	
		if(role == manager) {
			if(payCounter != totalPayPeriods) { //too ensure we cannot have more than 26 pay periods in year
				if(bonus <= managercomp) { //additional comp for specific role for each pay period cannot be more than total annual
					thePay = (annSalary/ totalPayPeriods) + bonus; 
					managercomp = managercomp - bonus; //after managerial employee paid part of add comp, what they can be paid for the rest of the year decrements by how much they were paid 
					payCounter++;	
				}
			}
		}else if(role == deptHead) {
			if(payCounter != totalPayPeriods) {
				if(bonus <= deptheadcomp) {
					thePay = (annSalary/ totalPayPeriods) + bonus; 
					deptheadcomp = deptheadcomp - bonus;
					payCounter++;
				}
			}
		}else if(role == director){
			if(payCounter != totalPayPeriods) {
				if(bonus <= directorcomp) {
					thePay = (annSalary/ totalPayPeriods) + bonus;
					directorcomp = directorcomp - bonus;
					payCounter++;	
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
		if(getRole() == manager) {
			roleOutput = super.toString() + "::Manager Compensation " + getTheBonus(); 
		}else if(getRole() == deptHead) {
			roleOutput = super.toString() + "::Director Compensation " + getTheBonus();
		}else if(getRole() == director) {
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
			return super.equals(obj) && role == ((Management) obj).role;
		}
		return false;
	}

}
