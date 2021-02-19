package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Employee {
	
	private Profile empProfile = new Profile(); //profile that uniquely identifies each employee
	private double paid;
	private DecimalFormat payment = new DecimalFormat("$###,###.##"); //Stores calculated payment, but idk if necessary
	
	/**
	Help intialize employee objects
	*/
	public Employee(Profile eProfile, double paidSalary) {
		// TODO Auto-generated constructor stub
		this.empProfile = eProfile;
		this.paid = paidSalary;
	}
	
	public void calculatePayment() {
		
	}
	
	public double getPaid() {
		return paid;
	}
	
	public Profile getempProfile() {
		return empProfile;
	}
	
	//Probably have to make setter and/or getter to convert from double to DecimalFormat for thePay
	
	/**
	@return  
	*/
	@Override
	public String toString() { 
		return empProfile.toString() + "::Payment " + payment;
	}
	
	//Still must check if this is correct, see what more to do
	//probably have to check for subclasses
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee objEmployee = (Employee) obj;
		if (this.empProfile.equals(objEmployee.empProfile) &&  this.payment.equals(objEmployee.payment)) {
			return true;
		}
		return false;
	}

}
