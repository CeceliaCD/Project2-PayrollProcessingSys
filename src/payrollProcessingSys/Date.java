package payrollProcessingSys;
import java.util.Calendar;
import java.util.StringTokenizer;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/

public class Date implements Comparable<Date> { 
	private int year;
	private int month; 
	private int day;
	
	public static final int QUAD = 4;
	public static final int CENT = 100;
	public static final int QUATER = 400;
	
	
	/**
	This method is taking a string in mm/dd/yyyy and creates
	a Date object that the user can input in a similar format.
	@param date of type String to create Date object 
	*/
	public Date(String date) {
		StringTokenizer dt = new StringTokenizer(date, "/");
		
		month = Integer.parseInt(dt.nextToken().trim());
		day = Integer.parseInt(dt.nextToken().trim());
		year = Integer.parseInt(dt.nextToken().trim());
	} 
	
	/**
	This constructor returns today’s date and also
	helps with checking if the given hire date of an
	employee is any later than the current (which shouldn't
	be possible).
	*/
	public Date() { 
		Calendar cal = Calendar.getInstance();
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
	} 
	
	/**
	Our getter method to help obtain the int value
	that represents a date's month.
	@return the month as an integer
	*/
	public int getMonth() {
		return month;
	}
	
	/**
	Our getter method that helps obtain the int
	value that represents a date's day.
	@return the day as an integer
	*/
	public int getDay() {
		return day;
	}
	
	/**
	Our getter method that helps obtain the int
	value that represents a date's year.
	@return the year as an integer
	*/
	public int getYear() {
		return year;
	}
	
	/**
	This method is used to help verify that the date given,
	which is representing when an employee was hired, is not
	imaginary/impossible or even older than from 1900.
	@return boolean true if the date not too old and realistic, false otherwise
	*/
	public boolean isValid() { 
		
		Calendar cal = Calendar.getInstance();
		int oldestPublishedyr = 1900;
		int lastDayFeb = 28;
		int lastDayFebLeap = 29;
		
		Date currDate = new Date(); //gives us the current date
		
	
		//YEAR
		if(year < oldestPublishedyr || year > currDate.getYear()) 
		{ 
			return false; 
		}
		
		
		//MONTH
		if((month > currDate.getMonth() || month > Calendar.MONTH+1) && year == currDate.getYear()) 
		{ 
			return false; 
		}else if(month > Calendar.DECEMBER+1 && year < currDate.getYear()) {
			return false;
		}	
	
		//Making sure the range of days for these months are 31 
		if(month == cal.get(Calendar.JANUARY+1) || month == cal.get(Calendar.MARCH+1) || month == cal.get(Calendar.MAY+1) 
				|| month == cal.get(Calendar.JULY+1) || month == cal.get(Calendar.AUGUST+1) || month == cal.get(Calendar.OCTOBER+1) 
				|| month == cal.get(Calendar.DECEMBER+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
		
		}
		
		//Making sure the range of days for these months are 30
		if(month == cal.get(Calendar.APRIL+1) || month == cal.get(Calendar.JUNE+1) 
				|| month == cal.get(Calendar.SEPTEMBER+1) || month == cal.get(Calendar.NOVEMBER+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
			
		}
		
		//DAY
		if((day > currDate.getDay() || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) && year == currDate.getYear()) 
		{ 
			return false; 
		}else if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) && year < currDate.getYear()) {
			return false;
		}else if(year%QUAD != 0) { //not a leap year
				
			if(month != cal.get(Calendar.FEBRUARY+1)) 
			{
				if(day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || day > lastDayFeb)
				{
					return false;
				}
						
			}
		}else if(year%CENT != 0) { //leap year
				
			if(month != cal.get(Calendar.FEBRUARY+1)) 
			{
				if(day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || day > lastDayFebLeap) 
				{
					return false;
				}
						
			}
		}else if(year%QUATER == 0) { //leap year
				
			if(month != cal.get(Calendar.FEBRUARY+1)) 
			{
				if(day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || day > lastDayFebLeap) 
				{
					return false;
				}
						
			} 
		} 
			
		return true;	
	}
	
	//idk if we should override this as well
	/**
	This method obtains the month, day an year variables of
	a date and returns a string variable to be processed and
	compared.
	@return a string variable of the month, day and year in mm/dd/yyyy format
	*/
	public String toString() {
		return  getMonth() + "/" + getDay() + "/" + getYear();
	}

	/**
	@param date is the Date type being compared to another date
    @return 1 if our date is lexicographically greater, -1 if otherwise, 0 if they are equal
	*/
	@Override
	public int compareTo(Date date) { //return 1, 0, or -1 
		int lessThan = -1;
		
		//first check year, then check month, then day
		if(year < date.year || (year < date.year && month < date.month) || (year < date.year && month < date.month && day < date.day)) 
			return lessThan; //our date is less than the given date
		
		if(year > date.year || (year > date.year && month > date.month) || (year > date.year && month > date.month && day > date.day)) 
			return 1; //our date is greater than the given date
		
		return 0; //they are the same date
		
	}
	
	public static void main(String[] args) {
		Date todaysDate = new Date();
		System.out.println("This is today's date: " + todaysDate.getMonth() + "/" + todaysDate.getDay() + "/" + todaysDate.getYear());
		
		Date date1 = new Date("02/0/2000"); //no such thing as day 0, invalid
		Boolean bool1 = date1.isValid();
		if(bool1 == true) {
			System.out.println(date1.getMonth() + "/" + date1.getDay() + "/" + date1.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date2 = new Date("2/29/2021"); 
		Boolean bool2 = date2.isValid();
		if(bool2 == true) {
			System.out.println(date2.getMonth() + "/" + date2.getDay() + "/" + date2.getYear());
		}else {
			System.out.println("Invalid Date!");
		}

		Date date3 = new Date("02/30/2000"); //should print invalid date since no such thinf as Feb 30th
		Boolean bool3 = date3.isValid();
		if(bool3 == true) {
			System.out.println(date3.getMonth() + "/" + date3.getDay() + "/" + date3.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date4 = new Date("2/29/2008"); //was a leap year so should print out
		Boolean bool4 = date4.isValid();
		if(bool4 == true) {
			System.out.println(date4.getMonth() + "/" + date4.getDay() + "/" + date4.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
	}
		
}
