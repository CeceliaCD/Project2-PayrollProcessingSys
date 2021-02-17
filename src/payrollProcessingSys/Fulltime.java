package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Fulltime extends Employee {
	
	private int fulltimepayperiods = 26;
	public DecimalFormat annualSalary = new DecimalFormat("#####");
	public static final int MANAGERCOMP = 5000; //1 additional compensation
	public static final int DEPTHEADCOMP = 9500; //2 aditional compensation
	public static final int DIRECTORCOMP = 12000; //3 additional compensation
	public static final int[] ROLE = new int[] {1,2,3};
	
	public DecimalFormat getAnnualSalary() {
		return annualSalary;
	}
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Fulltime() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void calculatePayment() { 
		for(int i=0; i< ROLE.length; i++) {
			if(ROLE[i] == 1) {
				
			}
		}
	}

}
