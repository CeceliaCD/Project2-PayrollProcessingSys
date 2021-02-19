package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	protected double managercomp = 5000; //1 additional compensation annually
	protected double deptheadcomp = 9500; //2 aditional compensation annually
	protected double directorcomp = 12000; //3 additional compensation annually
	protected double bonus;
	protected DecimalFormat theBonus = new DecimalFormat("$##,###.##");
	protected int manager = 1;
	protected int deptHead = 2;
	protected int director = 3;
	protected boolean mnger;
	protected boolean dpthd;
	protected boolean drctr;
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Management(Profile eProfile, double thePay, double annSalary, double theBonus) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay, annSalary);
		this.bonus = theBonus;
	}
	
	public double getBonus() {
		return bonus;
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
		int payCounter = 0;
		for(int i=0; i <= director; i++) { //each index of array represents a managerial role
			if(i == manager) {
				if(payCounter != super.fulltimepayperiods) { //too ensure we cannot have more than 26 pay periods in year
					if(bonus <= managercomp) { //additional comp for specific role for each pay period cannot be more than total annual
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + bonus; 
						managercomp = managercomp - bonus; //after managerial employee paid part of add comp, what they can be paid for the rest of the year decrements by how much they were paid 
						payCounter++;	
					}
				}
			}else if(i == deptHead) {
				if(payCounter != super.fulltimepayperiods) {
					if(bonus <= deptheadcomp) {
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + bonus; 
						deptheadcomp = deptheadcomp - bonus;
						payCounter++;
					}
				}
			}else {
				if(payCounter != super.fulltimepayperiods) {
					if(bonus <= directorcomp) {
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + bonus;
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
			roleOutput = super.toString() + "::Manager Compensation " + theBonus;
		}else if(getDpthd() == true) {
			roleOutput = super.toString() + "::Director Compensation " + theBonus;
		}else if(getDrctr() == true) {
			roleOutput = super.toString() + "::DepartmentHead Compensation " + theBonus;
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
