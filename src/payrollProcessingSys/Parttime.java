package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Parttime extends Employee {
	
	private int parttimeTotalHrs = 80; //The 2 week pay period
	public DecimalFormat hourlyRate = new DecimalFormat("##.##"); //Whatever parttimer is paid per hour
	public static final double OVERTIME = 1.5; //Represents time and a half regular hourly for more than 80 hours
	private int hoursWorked; // hours that a parttimer worked; does this need to be an int?
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Parttime() {
		// TODO Auto-generated constructor stub
	}
	public void setHourlyRate(DecimalFormat rate) {
		this.hourlyRate = rate;
	}
	
	public void setHoursWorked(int hours) {
		this.hoursWorked = hours;
	}
	@Override
	public void calculatePayment() { 
		
	}
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Parttime) {
			return super.equals(obj) && hourlyRate == ((Parttime) obj).hourlyRate;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
