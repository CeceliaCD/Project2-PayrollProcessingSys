package payrollProcessingSys;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Company {
	private Employee[] emplist; 
	private int numEmployee;
	private int CAPACITY = 4;
	
	public Company() { //default constructor to make empty employee system
		this.emplist = new Employee[CAPACITY];
		this.numEmployee = 0;
	}
	
	private int find(Employee employee) {
		for (int i = 0; i < emplist.length; i++) 
		{
			if (this.emplist[i] == null) 
			{
				return -1;
			}
			if (emplist[i].getempProfile().equals(employee.getempProfile()))
			{
				return i;
			}
		}
		return -1;
	}
	private void grow() { 
		Employee[] temp = new Employee[emplist.length + 4];
		for (int i = 0; i < emplist.length; i++) {
			temp[i] = emplist[i];
		}
		emplist = temp;
	}
	public boolean add(Employee employee) { // need to determine if employee is PT FT or M
		if (numEmployee%CAPACITY == 0 && numEmployee > 1) {
			grow();
		}
	} //check the profile before adding 
	public boolean remove(Employee employee) { // might have to change
		int rNum = find(employee);
		if (rNum == -1) {
			return false;
		}
		for (int i = rNum; i < numEmployee - 1; i++) {
			emplist[i] = emplist[i + 1];
		}
		emplist[numEmployee - 1] = null;
		numEmployee--;
		return true;
	} //maintain the original sequence 
	public boolean setHours(Employee employee) { //set working hours for a part time 
		
	} 
	public void processPayments() { //process payments for all employees
		
	} 
	public void print() { //print earning statements for all employees
		if(numEmployee != 0) {
			System.out.println("--Printing earning statements for all employees--");
			for(int i=0; i < emplist.length; i++) 
			{
				if (emplist[i] != null) //to ensure no null elements are printed
				{  
					System.out.println(emplist[i]);
				}
			}
		}else {
			System.out.println("Employee database is empty.");
		}
	} 
	public void printByDepartment() { //print earning statements by department 
		
	} 
	public void printByDate() { //print earning statements by date hired
		
	} 

}
