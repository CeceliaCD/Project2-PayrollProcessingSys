package payrollProcessingSys;

import java.text.DecimalFormat;

/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Employee {
	
	private Profile empProfile = new Profile(); //profile that uniquely identifies each employee
	private double paid;
	
	/**
	This constructor helps intialize employee objects
	@param
	*/
	public Employee(Profile eProfile, double paidSalary) {
		// TODO Auto-generated constructor stub
		this.empProfile = eProfile;
		this.paid = paidSalary;
	}
	
	/**
	@return
	*/
	public Profile getempProfile() {
		return empProfile;
	}
	
	/**
	@return
	*/
	public double getPaid() {
		return paid;
	}
	
	/**
	@return
	*/
	public String getDollarValue() {
		String dollarValue = "";
		return dollarValue = new DecimalFormat("$###,###.##").format(getPaid());
	}
	
	/**
	@param 
	*/
	public void setPaid(double paid) {
		this.paid = paid;
	}
	
	/**
	 
	*/
	@Override
	public void calculatePayment() {
		paid = 0.0;
	}
	
	/**
	@return  
	*/
	@Override
	public String toString() { 
		return empProfile.toString() + "::Payment " + getDollarValue();
	}
	
	/**
	@param
	@return
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee objEmp = (Employee) obj;
		if (this.empProfile.equals(objEmp.empProfile) && this.paid == objEmp.paid) {
			return true;
		}
		return false;
	}

}
