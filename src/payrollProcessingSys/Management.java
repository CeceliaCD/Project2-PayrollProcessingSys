package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	private double managercomp = 5000; //1 additional compensation annually
	private double deptheadcomp = 9500; //2 aditional compensation annually
	private double directorcomp = 12000; //3 additional compensation annually
	private double addcompforperiod;
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Management() {
		// TODO Auto-generated constructor stub
	}
	
	public double getAddCompforPeriod() {
		return addcompforperiod;
	}
	/**
	According to the given role number, calculates the earning for the pay period
	*/
	@Override
	public void calculatePayment() { 
		int manager = 1;
		int deptHead = 2;
		int director = 3;
		int[] role = new int[] {manager, deptHead, director};
		int payCounter = 0;
		for(int i=0; i< role.length; i++) { //each index of array represents a managerial role
			if(role[i] == manager) {
				if(payCounter != super.fulltimepayperiods) { //too ensure we cannot have more than 26 pay periods in year
					if(addcompforperiod <= managercomp) { //additional comp for specific role for each pay period cannot be more than total annual
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + addcompforperiod; 
						managercomp = managercomp - addcompforperiod; //after managerial employee paid part of add comp, what they can be paid for the rest of the year decrements by how much they were paid 
						payCounter++;	
					}
				}
			}else if(role[i] == deptHead) {
				if(payCounter != super.fulltimepayperiods) {
					if(addcompforperiod <= deptheadcomp) {
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + addcompforperiod; 
						deptheadcomp = deptheadcomp - addcompforperiod;
						payCounter++;
					}
				}
			}else {
				if(payCounter != super.fulltimepayperiods) {
					if(addcompforperiod <= directorcomp) {
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + addcompforperiod;
						directorcomp = directorcomp - addcompforperiod;
						payCounter++;
						
					}	
				}
			}
		}
		
	}

}
