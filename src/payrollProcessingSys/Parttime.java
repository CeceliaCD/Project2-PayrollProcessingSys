package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Parttime extends Employee {
	
	private String hourlyRate = "";
	private double hrlyRate;
	private static final double OVERTIME = 1.5; //Represents time and a half regular hourly for more than 80 hours
	private int hoursWorked; // hours that a parttimer worked; does this need to be an int?
	private int parttimeTotalHrs = 80; //The 2 week pay period
	private int hoursLimit = 100; //hours worked cannot exceed 100 hours per week
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Parttime(Profile eProfile, double paidSalary, double hrlyRate, int hrsWorked) {
		// TODO Auto-generated constructor stub
		super(eProfile, paidSalary);
		this.hrlyRate = hrlyRate;
		this.hoursWorked = hrsWorked;
	}
	
	public String getHourlyRate() {
		return hourlyRate = new DecimalFormat("$##.##").format(hrlyRate);
		
	}
	
	public void setHourlyRate(double rate) {
		this.hourlyRate = Double.toString(rate);
	}
	
	public void setHoursWorked(int hours) {
		this.hoursWorked = hours;
	}
	
	@Override
	public void calculatePayment() { 
		//parttimeTotalHrs = new DecimalFormat("##.##");
		//DecimalFormat payPeriod = new DecimalFormat("##.##");
		//payPeriod =	hourlyRate * (DecimalFormat)hoursWorked;
		if(hoursWorked >= 0) {
			double paidSalary = super.getPaid();
			if(hoursWorked <= parttimeTotalHrs) {
				paidSalary = hrlyRate * hoursWorked;
				String payPeriod = new DecimalFormat("$###,###.##").format(paidSalary);
			}else if(hoursWorked > parttimeTotalHrs && hoursWorked <= hoursLimit) {
				int overtimeDiff = hoursWorked - parttimeTotalHrs;
				paidSalary = (hrlyRate * parttimeTotalHrs) + (OVERTIME * overtimeDiff);
				String payPeriod = new DecimalFormat("$###,###.##").format(paidSalary);
			}	
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "::PART TIME::Hourly Rate " + getHourlyRate() + "::Hours worked this period: " + Integer.toString(hoursWorked);
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Parttime) {
			return super.equals(obj) && hourlyRate == ((Parttime) obj).hourlyRate;
		}
		return false;
	}

}
