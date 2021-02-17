package payrollProcessingSys;
import java.util.Calendar;
import java.util.StringTokenizer;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
//implements Comparable<Date>
public class Date  { 
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
	helps with checking if the given published date of 
	a book is any later than the current (which shouldn't
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
	which is representing when a book was published, is not
	imaginary/impossible or even older than books published 
	in 1900.Returns a boolean to indicate if the published 
	date of a book the user has inputted is valid.
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
		}else if(year%QUAD == 0 && year%CENT == 0 && year%QUATER == 0) { //leap year
				
			if(month == cal.get(Calendar.FEBRUARY+1)) 
			{
				cal.set(cal.getMaximum(Calendar.DATE), lastDayFebLeap);
				if(day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || day > lastDayFebLeap)
				{
					return false;
				}
						
			}
		}else if(year%CENT != 0) { //leap year
				
			if(month == cal.get(Calendar.FEBRUARY+1)) 
			{
				cal.set(cal.getMaximum(Calendar.DATE), lastDayFebLeap);
				if(day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || day > lastDayFebLeap) 
				{
					return false;
				}
						
			}
		}else if(year%QUAD != 0 || year%QUATER != 0) { //not a leap year
				
			if(month == cal.get(Calendar.FEBRUARY+1)) 
			{
				cal.set(cal.getMaximum(Calendar.DATE), lastDayFeb);
				if(day < cal.getActualMinimum(Calendar.DAY_OF_MONTH) || day > lastDayFeb) 
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

	//positive if first string is lexico greater, negative if otherwise, 0 if equal
	/*@Override
	public int compareTo(Date date) { //return 1, 0, or -1 
		//get year, then month, then day
		Date givenDate;
		int lessThan = -1;
		
		int yearComparison = givenDate.toString(getYear()).compareTo(date.toString(getYear()));
		int monthComparison = givenDate.toString(getMonth()).compareTo(date.toString(getMonth()));
		int dayComparison = givenDate.toString(getDay()).compareTo(date.toString(getDay()));
		
		//first check year, then check month, then day
		if(yearComparison == lessThan || (yearComparison == lessThan && monthComparison == lessThan) || (yearComparison == lessThan && monthComparison == lessThan && dayComparison == lessThan)) 
			return lessThan;
		
		if(yearComparison == 1 || (yearComparison == 1 && monthComparison == 1) || (yearComparison == 1 && monthComparison == 1 && dayComparison == 1)) 
			return 1;
		
		
		if(yearComparison == 0 && monthComparison == 0 && dayComparison == 0) 
			return 0;
		
	}*/
	
	public static void main(String[] args) {
		Date todaysDate = new Date();
		System.out.println("This is today's date: " + todaysDate.getMonth() + "/" + todaysDate.getDay() + "/" + todaysDate.getYear());
		
		Date date1 = new Date("31/2/2000");
		Boolean bool1 = date1.isValid();
		if(bool1 == true) {
			System.out.println(date1.getMonth() + "/" + date1.getDay() + "/" + date1.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date = new Date("13/2/2020");
		Boolean boold = date.isValid();
		if(boold == true) {
			System.out.println(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
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

		Date date3 = new Date("02/30/2000"); //should print invalid date since 2009 isn't leap year p.s. issue must have to be days check
		Boolean bool3 = date3.isValid();
		if(bool3 == true) {
			System.out.println(date3.getMonth() + "/" + date3.getDay() + "/" + date3.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date4 = new Date("4/31/2009");
		Boolean bool4 = date4.isValid();
		if(bool4 == true) {
			System.out.println(date4.getMonth() + "/" + date4.getDay() + "/" + date4.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date5 = new Date("3/32/2009");
		Boolean bool5 = date5.isValid();
		if(bool5 == true) {
			System.out.println(date5.getMonth() + "/" + date5.getDay() + "/" + date5.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date6 = new Date("3/31/1800");
		Boolean bool6 = date6.isValid();
		if(bool6 == true) {
			System.out.println(date6.getMonth() + "/" + date6.getDay() + "/" + date6.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date7 = new Date("10/30/2022");
		Boolean bool7 = date7.isValid();
		if(bool7 == true) {
			System.out.println(date7.getMonth() + "/" + date7.getDay() + "/" + date7.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date8 = new Date("3/35/2021");
		Boolean bool8 = date8.isValid();
		if(bool8 == true) {
			System.out.println(date8.getMonth() + "/" + date8.getDay() + "/" + date8.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
		
		Date date9 = new Date("11/31/2020");
		Boolean bool9 = date8.isValid();
		if(bool9 == true) {
			System.out.println(date9.getMonth() + "/" + date9.getDay() + "/" + date9.getYear());
		}else {
			System.out.println("Invalid Date!");
		}
	}
		
	}
