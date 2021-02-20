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
	
	public double getPaid() {
		return paid;
	}
	
	public String getDollarValue() {
		String dollarValue = "";
		return dollarValue = new DecimalFormat("$###,###.##").format(paid);
	}
	
	public void setPaid(double paid) {
		this.paid = paid;
	}
	
	public Profile getempProfile() {
		return empProfile;
	}
	@Override
	public void calculatePayment() {
		
	}
	
	
	/**
	@return  
	*/
	@Override
	public String toString() { 
		return empProfile.toString() + "::Payment " + getDollarValue();
	}
	
	//
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee objEmp = (Employee) obj;
		if (this.empProfile.equals(objEmp.empProfile)) {
			return true;
		}
		return false;
	}

}
