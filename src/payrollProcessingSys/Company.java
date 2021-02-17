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
			if (emplist[i].getName().equals(employee.getName())) //Not working because still need to finish Employee class
			{
				return i;
			}
		}
		return -1;
	}
	private void grow() { }
	public boolean add(Employee employee) { } //check the profile before adding 
	public boolean remove(Employee employee) { } //maintain the original sequence 
	public boolean setHours(Employee employee) { } //set working hours for a part time 
	public void processPayments() { } //process payments for all employees
	public void print() { } //print earning statements for all employees
	public void printByDepartment() { } //print earning statements by department 
	public void printByDate() { } //print earning statements by date hired

}
