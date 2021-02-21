package payrollProcessingSys;

/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Company {
	private Employee[] emplist; 
	private int numEmployee;
	private int CAPACITY = 4;
	
	/**
	 
	*/
	public Company() { //default constructor to make empty employee system
		this.emplist = new Employee[CAPACITY];
		this.numEmployee = 0;
	}
	
	/**
	@param
	@return 
	*/
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
	
	/**
	 
	*/
	private void grow() { 
		Employee[] temp = new Employee[emplist.length + 4];
		for (int i = 0; i < emplist.length; i++) {
			temp[i] = emplist[i];
		}
		emplist = temp;
	}
	
	/**
	@param
	@return 
	*/
	public boolean add(Employee employee) { // need to determine if employee is PT FT or M
		if (numEmployee % CAPACITY == 0 && numEmployee > 1) {
			grow();
		}
		if (find(employee) == -1) {
			emplist[numEmployee] = employee;
			numEmployee++;
			return true;
		}
		else {
			return false;
		}
	} //check the profile before adding 
	
	/**
	@param
	@return 
	*/
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
	
	/**
	@param
	@return 
	*/
	public boolean setHours(Employee employee) { //set working hours for a part time 
		
	} 
	
	/**
	 
	*/
	public void processPayments() { //process payments for all employees
		
	} 
	
	/**
 
	*/
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
	
	/**
	
	*/
	public void printByDepartment() { //print earning statements by department 
		if(numEmployee != 0) {
			Employee tempEmpDept;
			
			for(int i=0; i < emplist.length; i++)
			{
				for(int j=i+1; j < emplist.length; j++)
				{
					if(emplist[i] != null && emplist[j] != null) //helps with null elements
					{ 
						String dept1 = emplist[i].getempProfile().getDept();
						String dept2 = emplist[j].getempProfile().getDept();
						if(dept1.compareTo(dept2) > 0) 
						{
							tempEmpDept = emplist[i];
							emplist[i] = emplist[j];
							emplist[j] = tempEmpDept;	
						}else if(dept1.compareTo(dept2) == 0) {
							String tempEmpName1 = emplist[i].getempProfile().getName();
							String tempEmpName2 = emplist[j].getempProfile().getName();
							if(tempEmpName1.compareTo(tempEmpName2) > 0) {
								Employee temp =  emplist[i];
								emplist[i] = emplist[j];
								emplist[j] = temp;
							}
						}
					}else if(emplist[i] == null && emplist[j] != null) {
						emplist[i] = emplist[j];
					}else if(emplist[i] != null && emplist[j] == null) {
						continue;
					}
				}
			}
			
			System.out.println("--Printing earning statements by department--");
			for(int k=0; k < emplist.length; k++) {
				if (emplist[k] != null) 
				{
					System.out.println(emplist[k]);
				}	
			}	
		}else {
			System.out.println("Employee database is empty.");
		}
	} 
	
	/**
	
	*/
	public void printByDate() { //print earning statements by date hired
		if(numEmployee != 0) {
			Employee tempEmployee;
			
			for(int i=0; i < emplist.length; i++)
			{
				for(int j=i+1; j< emplist.length; j++)
				{
					if(emplist[i] != null && emplist[j] != null) //helps with null elements
					{ 
						Date dateHired1= emplist[i].getempProfile().getDateHired();
						Date dateHired2= emplist[j].getempProfile().getDateHired();
						
						if(dateHired1.compareTo(dateHired2) == 1) 
						{
								tempEmployee = emplist[i];
								emplist[i] = emplist[j];
								emplist[j] = tempEmployee;
						}else if(dateHired1.compareTo(dateHired2) == 0) {
							String dept1 = emplist[i].getempProfile().getDept();
							String dept2 = emplist[j].getempProfile().getDept();
							if(dept1.compareTo(dept2) > 0) 
							{
									Employee tempEE = emplist[i];
									emplist[i] = emplist[j];
									emplist[j] = tempEE;
							}else if(dept1.compareTo(dept2) == 0) {
								String name1 = emplist[i].getempProfile().getName();
								String name2 = emplist[j].getempProfile().getName();
								if(name1.compareTo(name2) > 0) {
									Employee temp = emplist[i];
									emplist[i] = emplist[j];
									emplist[j] = temp;
								}
							}
						}
					}else if(emplist[i] == null && emplist[j] != null) {
						emplist[i] = emplist[j];
					}else if(emplist[i] != null && emplist[j] == null) {
						continue;
					}
				}
			}
			
			System.out.println("--Printing earning statements by date hired--");
			for(int j=0; j < emplist.length; j++) {
				if (emplist[j] != null) 
				{
					System.out.println(emplist[j]);
				}
			}
		}else {
			System.out.println("Employee database is empty.");
		}
	} 

}
