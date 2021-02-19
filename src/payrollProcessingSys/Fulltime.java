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
		super();
	}
	
	//Do I calculate here for employees that don't have managerial roles? -Cecelia
	@Override
	public void calculatePayment() {
		 super.paid = annualSalary/fulltimepayperiods;
	}
	
	@Override
	public String toString() { 
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fulltime) {
			return super.equals(obj) && getAnnualSalary() == ((Fulltime) obj).getAnnualSalary();
		}
		return false;
	}

}
