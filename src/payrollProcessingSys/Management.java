package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	private double managercomp = 5000; //1 additional compensation annually
	private double deptheadcomp = 9500; //2 aditional compensation annually
	private double directorcomp = 12000; //3 additional compensation annually
	private double bonus;
	private int manager = 1;
	private int deptHead = 2;
	private int director = 3;
	private boolean mnger;
	private boolean dpthd;
	private boolean drctr;
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Management(Profile eProfile, double thePay, double annSalary, double theBonus) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay, annSalary);
		this.bonus = theBonus;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public String getTheBonus() {
		String theBonus = "";
		return theBonus = new DecimalFormat("$##,###.##").format(bonus);
	}
	
	public boolean getMnger() { 
		return mnger;
	}
	
	public boolean getDpthd() {
		return dpthd;
	}
	
	public boolean getDrctr() {
		return drctr;
	}
	
	public void setMnger(boolean mnger) { 
		this.mnger = mnger;
	}
	
	public void setDpthd(boolean dpthd) {
		this.dpthd = dpthd;
	}
	
	public void setDrctr(boolean drctr) {
		this.drctr = drctr;
	}
	
	
	/** 
	According to the given role number, calculates the earning for the pay period
	*/
	@Override
	public void calculatePayment() { 
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
	
	//Have to make setter and/or getter to convert from double to DecimalFormat for theBonus
	
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Management) {
			return super.equals(obj) && bonus == ((Management) obj).bonus;
		}
		return false;
	}

}
