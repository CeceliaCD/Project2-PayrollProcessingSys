package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Fulltime extends Employee {
	
	private int fulltimepayperiods = 26;
	private double annualSalary;
	
	/**
	@param
	*/
	public Fulltime(Profile eProfile, double thePay, double annSalary) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay);
		this.annualSalary = annSalary;
	}
	
	/**
	@return
	*/
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	/**
	@return
	*/
	public String getAnnSalary() {
		String yearlySal = "";
		return yearlySal = new DecimalFormat("$###,###.##").format(annualSalary);
	}
	
	/**
	@return 
	*/
	public int getFTPayPeriods() {
		return fulltimepayperiods;
	}
	
	/**
	 
	*/
	@Override
	public void calculatePayment() {
		double thePay = super.getPaid();
		thePay = annualSalary/fulltimepayperiods;
	}
	
	/**
	@return 
	*/
	@Override
	public String toString() {
		return super.toString() + "::FULL TIME::Annual Salary " + getAnnSalary();
	}
	
	/**
	@param
	@return
	*/
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fulltime) {
			return super.equals(obj) && getAnnualSalary() == ((Fulltime) obj).getAnnualSalary();
		}
		return false;
	}

}
