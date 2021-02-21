package payrollProcessingSys;

import java.text.DecimalFormat;

/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Parttime extends Employee {
	
	private double hourlyRate;
	private static final double OVERTIME = 1.5; //Represents time and a half regular hourly for more than 80 hours
	private int hoursWorked; // hours that a parttimer worked, int bc paid every hour worked
	
	/**
	@param
	*/
	public Parttime(Profile eProfile, double paidSalary, double hrlyrate, int hrsWorked) {
		// TODO Auto-generated constructor stub
		super(eProfile, paidSalary);
		this.hourlyRate = hrlyrate;
		this.hoursWorked = hrsWorked;
	}
	
	/**
	@return
	*/
	public String getHourlyRate() {
		String hrlyRate = ""; 
		return hrlyRate = new DecimalFormat("$##.##").format(hourlyRate);
		
	}
	
	/**
	@param 
	*/
	public void setHourlyRate(double rate) {
		this.hourlyRate = rate;
	}
	
	/**
	@param 
	*/
	public void setHoursWorked(int hours) {
		this.hoursWorked = hours;
	}
	
	/**
	
	*/
	@Override
	public void calculatePayment() { 
		//parttimeTotalHrs = new DecimalFormat("##.##");
		//DecimalFormat payPeriod = new DecimalFormat("##.##");
		//payPeriod =	hourlyRate * (DecimalFormat)hoursWorked;
		int parttimeTotalHrs = 80; //The 2 week pay period
		int hoursLimit = 100; //hours worked cannot exceed 100 hours per week
		if(hoursWorked >= 0) {
			double paidSalary = super.getPaid();
			if(hoursWorked <= parttimeTotalHrs) {
				paidSalary = hourlyRate * hoursWorked;
				String payPeriod = new DecimalFormat("$###,###.##").format(paidSalary); //these might not be needed
			}else if(hoursWorked > parttimeTotalHrs && hoursWorked <= hoursLimit) {
				int overtimeDiff = hoursWorked - parttimeTotalHrs;
				paidSalary = (hourlyRate * parttimeTotalHrs) + (OVERTIME * overtimeDiff);
				String payPeriod = new DecimalFormat("$###,###.##").format(paidSalary); //these might not be needed
			}	
		}
	}
	
	/**
	@return
	*/
	@Override
	public String toString() {
		return super.toString() + "::PART TIME::Hourly Rate " + getHourlyRate() + "::Hours worked this period: " + Integer.toString(hoursWorked);
	}
	
	/**
	@param
	@return
	*/
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Parttime) {
			return super.equals(obj) && hourlyRate == ((Parttime) obj).hourlyRate;
		}
		return false;
	}

}
