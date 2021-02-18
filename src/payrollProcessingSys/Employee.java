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
	
	
	//left as empty method because superclass but still wondering if should be called abstract
	public void calculatePayment() {
		
	}
	
	@Override
	public String toString() { 
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
	}

}
