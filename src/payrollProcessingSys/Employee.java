package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Employee {
	
	private Profile empProfile; //profile that uniquely identifies each employee
	protected double paid;
	private  DecimalFormat thePay = new DecimalFormat("$###,###.##"); //Stores calculated payment, but idk if necessary
	
	/**
	Help intialize employee objects
	*/
	public Employee() {
		// TODO Auto-generated constructor stub
		this.empProfile = new Profile();
		this.paid = 0;
	}
	
	public void calculatePayment() {
		
	}
	
	/**
	@return  
	*/
	@Override
	public String toString() { 
		//if(obj instanceof Fulltime) {
			
		//}
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
		if (this.empProfile.equals(objEmployee.empProfile) &&  this.thePay.equals(objEmployee.thePay)) {
			return true;
		}
		return false;
	}

}
