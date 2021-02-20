package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Fulltime extends Employee {
	
	private int fulltimepayperiods = 26;
	private double annualSalary;
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public String getAnnSalary() {
		String yearlySal = "";
		return yearlySal = new DecimalFormat("$###,###.##").format(annualSalary);
	}
	
	public int getFTPayPeriods() {
		return fulltimepayperiods;
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
		double thePay = super.getPaid();
		thePay = annualSalary/fulltimepayperiods;
	}
	
	@Override
	public String toString() {
		return super.toString() + "::FULL TIME::Annual Salary " + getAnnSalary();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fulltime) {
			return super.equals(obj) && getAnnualSalary() == ((Fulltime) obj).getAnnualSalary();
		}
		return false;
	}

}
