package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Employee {
	
	private Profile empProfile = new Profile(); //profile that uniquely identifies each employee
	private double paid;
	
	/**
	Help intialize employee objects
	*/
	public Employee(Profile eProfile, double paidSalary) {
		// TODO Auto-generated constructor stub
		this.empProfile = eProfile;
		this.paid = paidSalary;
	}
	
	@Override
	public void calculatePayment() {
		
	}
	
	public double getPaid() {
		return paid;
	}
	
	public void setPaid(double paid) {
		this.paid = paid;
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
		return empProfile.toString() + "::Payment " + getdollarValue();
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
		if (this.empProfile.equals(objEmployee.empProfile) &&  this.paid.equals(objEmployee.paid)) {
			return true;
		}
		return false;
	}

}
