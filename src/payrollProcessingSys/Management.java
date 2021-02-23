package payrollProcessingSys;

import java.text.DecimalFormat;

/**
The management class is a subclass of our fulltime class.
This means employees that have managerial roles are also
considered fulltime employees, thus have the same 26 pay 
periods. We define three types of managerial roles: manager,
department head, and director. In this class their bi-weekly
payments are calculated in a similar fashion, but they are 
different because the limit for their additional annual 
compensations are different.
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	
	private double bonus; //whatever amount the user gives in for the respective role's bonus
	private int role; //whatever value the user gives for the role
	private int manager = 1;
	private int deptHead = 2;
	private int director = 3;
	
	/**
	The parameterized constructor that specifies what specific attributes a fulltime
	employee with a managerial role must have.
	@param profile consisting of employee's name, department and date of hire, along with what they're paid each period, annual salary, and managerial role
	*/
	public Management(Profile eProfile, double thePay, double annSalary, int theRole, double theBonus) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay, annSalary);
		this.role = theRole;
		this.bonus = theBonus;
	}
	
	/**
	Getter method to obtain an employee's bonus this period.
	@return the double value of the employee's bonus
	*/
	public double getBonus() {
		return bonus;
	}
	
	/**
	Getter method to obtain an employee's bonus in decimal format.
	@return the decimal format of the bonus with two decimal places and dollar value
	*/
	public String getTheBonus() {
		String theBonus = "";
		return theBonus = new DecimalFormat("$##,###.##").format(bonus);
	}
	
	/**
	Getter method to obtain an employee's integer representation of their managerial role.
	@return the integer value of manager (1), department head (2), or director (3)
	*/
	public int getRole() { 
		return role;
	}
	
	/**
	Setter method to set the bonus for an employee during the current pay period.
	@param double value of the bonus that an employee of a managerial role is given
	*/
	public void setBonus(double theBonus) {
		this.bonus = theBonus;
	}
	
	/**
	Setter method to set the role for an employee entering the company.
	@param the integer value of the role that will be given to an employee of managerial status
	*/
	public void setRole(int theRole) {
		this.role = theRole;
	}
	
	/** 
	According to the given role number, calculates the earnings for the pay period.
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
	Gives the specified employee object, in this case employees of managerial status,
	an ouptut of their information and finances within the company.
	@return string value of their profile information, their managerial status, and how much they get each period in additional compensation
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
	Compares another object to the current employee object of type management
	and checks if the object is also of the employee of type management.
	@param object that is to be compared to our management object
	@return true if they are the same object, false otherwise
	*/
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Management) {
			return super.equals(obj) && role == ((Management) obj).role;
		}
		return false;
	}

}
