package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Fulltime extends Employee {
	
	protected int fulltimepayperiods = 26;
	protected double annualSalary;
	public DecimalFormat theSalary = new DecimalFormat("#####");
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Fulltime() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void calculatePayment() {
		
	}
	
	@Override
	public String toString() { 
		
	}

}
