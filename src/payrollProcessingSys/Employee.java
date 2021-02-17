package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Employee {
	
	private Profile empProfile = new Profile(); //profile that uniquely identifies each employee
	private DecimalFormat PAID = new DecimalFormat("$##,###.##"); //Stores calculated payment, but idk if necessary
	
	/**
	Help intialize employee objects
	*/
	public Employee() {
		// TODO Auto-generated constructor stub
		
	}
	
	//idk
	public String getProfile() {
		return empProfile.toString();
	}
	
	//left as empty method for now
	public void calculatePayment() {
		
	}

}
