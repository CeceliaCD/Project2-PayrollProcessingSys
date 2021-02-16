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
	@return boolea true if the date not too old and realistic, false otherwise
	*/
	public boolean isValid() { 
		
		Calendar cal = Calendar.getInstance();
		int oldestPublishedyr = 1900;
		final int quad = 4;
		final int cent = 100;
		final int quater = 400;
		
		
		Date currDate = new Date(); //gives us the current date
			
		if((month > currDate.getMonth() || month > Calendar.MONTH+1) && year == currDate.getYear()) 
		{ 
			return false; 
		}else if(month > Calendar.DECEMBER+1 && year < currDate.getYear()) {
			return false;
		}
			
		if((day > currDate.getDay() || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) && year == currDate.getYear()) 
		{ 
			return false; 
		}else if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) && year < currDate.getYear()) {
			return false;
		}
			
		if(year < oldestPublishedyr || year > currDate.getYear()) 
		{ 
			return false; 
		}
	
		if(month == cal.get(Calendar.JANUARY+1) || month == cal.get(Calendar.MARCH+1) || month == cal.get(Calendar.MAY+1) 
				|| month == cal.get(Calendar.JULY+1) || month == cal.get(Calendar.AUGUST+1) || month == cal.get(Calendar.OCTOBER+1) 
				|| month == cal.get(Calendar.DECEMBER+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
		
		}
		
		if(month == cal.get(Calendar.APRIL+1) || month == cal.get(Calendar.JUNE+1) 
				|| month == cal.get(Calendar.SEPTEMBER+1) || month == cal.get(Calendar.NOVEMBER+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
			
		}
		
		boolean leapyr = (year/quad == 0) ? true : false;
		leapyr = (year/cent == 0) ? true : false;
		leapyr = (year/quater == 0) ? true : false;
		
		
		if(leapyr == false && month == cal.get(Calendar.FEBRUARY+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
		
		}
		
		
		if(leapyr == true && month == cal.get(Calendar.FEBRUARY+1)) 
		{
			if(day < cal.getMinimum(Calendar.DAY_OF_MONTH) || day > cal.getMaximum(Calendar.DAY_OF_MONTH)) 
			{
				return false;
			}
		
		}
		
		return true;	
	}
	
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
	@Override
	public int compareTo(Date date) { //return 1, 0, or -1 
		//get year, then month, then day
		Date givenDate;
		
		int yearComparison = givenDate.toString(getYear()).compareTo(date.toString(getYear()));
		int monthComparison = givenDate.toString(getMonth()).compareTo(date.toString(getMonth()));
		int dayComparison = givenDate.toString(getDay()).compareTo(date.toString(getDay()));
		
		//first check year, then check month, then day
		if(yearComparison == -1 || (yearComparison == -1 && monthComparison == -1) || (yearComparison == -1 && monthComparison == -1 && dayComparison == -1)) 
			return -1;
		
		if(yearComparison == 1 || (yearComparison == 1 && monthComparison == 1) || (yearComparison == 1 && monthComparison == 1 && dayComparison == 1)) 
			return 1;
		
		
		if(yearComparison == 0 && monthComparison == 0 && dayComparison == 0) 
			return 0;
		
	} 
}
