package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Management extends Fulltime {
	private double managercomp = 5000; //1 additional compensation annually
	private double deptheadcomp = 9500; //2 aditional compensation annually
	private double directorcomp = 12000; //3 additional compensation annually
	private double bonus;
	private int manager = 1;
	private int deptHead = 2;
	private int director = 3;
	private boolean mnger;
	private boolean dpthd;
	private boolean drctr;
	
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Management(Profile eProfile, double thePay, double annSalary, double theBonus) {
		// TODO Auto-generated constructor stub
		super(eProfile, thePay, annSalary);
		this.bonus = theBonus;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	
	/**
	According to the given role number, calculates the earning for the pay period
	*/
	@Override
	public void calculatePayment() { 
		int payCounter = 0;
		for(int i=0; i <= director; i++) { //each index of array represents a managerial role
			if(i == manager) {
				if(payCounter != super.fulltimepayperiods) { //too ensure we cannot have more than 26 pay periods in year
					if(bonus <= managercomp) { //additional comp for specific role for each pay period cannot be more than total annual
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + bonus; 
						managercomp = managercomp - bonus; //after managerial employee paid part of add comp, what they can be paid for the rest of the year decrements by how much they were paid 
						payCounter++;	
					}
				}
			}else if(i == deptHead) {
				if(payCounter != super.fulltimepayperiods) {
					if(bonus <= deptheadcomp) {
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + bonus; 
						deptheadcomp = deptheadcomp - bonus;
						payCounter++;
					}
				}
			}else {
				if(payCounter != super.fulltimepayperiods) {
					if(bonus <= directorcomp) {
						super.paid = (super.annualSalary/ super.fulltimepayperiods) + bonus;
						directorcomp = directorcomp - bonus;
						payCounter++;
						
					}	
				}
			}
		}
		
	}
	
	@Override
	public String toString() { 
		return super.toString() + ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Management) {
			return super.equals(obj) && bonus == ((Management) obj).bonus;
		}
		return false;
	}

}
