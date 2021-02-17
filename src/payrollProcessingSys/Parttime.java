package payrollProcessingSys;
import java.text.DecimalFormat;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Parttime extends Employee {
	
	private int parttimeTotalHrs = 80; //The 2 week pay period
	public DecimalFormat hourlyRate = new DecimalFormat("##.##"); //Whatever parttimer is paid per hour
	public static final double OVERTIME = 1.5; //Represents time and a half regular hourly for more than 80 hours
	
	//Right now I don't think these subclass constructors are necessary since there is only employee objects
	public Parttime() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void calculatePayment() { 
		
	}

}
