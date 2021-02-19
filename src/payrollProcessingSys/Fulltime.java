package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Fulltime extends Employee {
	
	protected int fulltimepayperiods = 26;
	protected double annualSalary;
	protected DecimalFormat theSalary = new DecimalFormat("$##,###.##");
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Fulltime(Profile eProfile, double thePay, double annSalary) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay);
		this.annualSalary = annSalary;
	}
	
	//Do I calculate here for employees that don't have managerial roles? -Cecelia
	@Override
	public void calculatePayment() {
		 super.paid = annualSalary/fulltimepayperiods;
	}
	
	//Probably have to make setter and/or getter to convert from double to DecimalFormat for theSalary
	
	@Override
	public String toString() {
		return super.toString() + "::FULL TIME::Annual Salary " + theSalary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fulltime) {
			return super.equals(obj) && getAnnualSalary() == ((Fulltime) obj).getAnnualSalary();
		}
		return false;
	}

}
