package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	public static final int MANAGERCOMP = 5000; //1 additional compensation annually
	public static final int DEPTHEADCOMP = 9500; //2 aditional compensation annually
	public static final int DIRECTORCOMP = 12000; //3 additional compensation annually

	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Management() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	According to the given role number, calculates the earning for  the pay period
	*/
	@Override
	public void calculatePayment() { 
		int manager = 1;
		int deptHead = 2;
		int director = 3;
		int[] role = new int[] {manager, deptHead, director};
		int payCounter = 0;
		for(int i=0; i< role.length; i++) {
			if(role[i] == manager) {
				if(payCounter != super.fulltimepayperiods) {
					super.paid = super.annualSalary/ super.fulltimepayperiods; 
					payCounter++;	
				}
			}else if(role[i] == deptHead) {
				if(payCounter != super.fulltimepayperiods) {
					super.paid = super.annualSalary/ super.fulltimepayperiods; 
					payCounter++;	
				}
			}else {
				if(payCounter != super.fulltimepayperiods) {
					super.paid = super.annualSalary/ super.fulltimepayperiods; 
					payCounter++;	
				}
			}
		}
		
	}

}
