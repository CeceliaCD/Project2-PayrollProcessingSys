package payrollProcessingSys;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Profile {
	private String name; //employee’s name in the form “lastname,firstname” 
	private String department; //department code: CS, ECE, IT
	private Date dateHired;
	
	public String getName() {
		return name;
	}
	
	public String getDept() {
		return department;
	}
	
	public Date getDateHired() {
		return dateHired;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDept(String dept) {
		this.department = dept;
	}
	
	public void setDateHired(Date hired) {
		this.dateHired = hired;
	}
	
	@Override
	public String toString() { 
		String outputProfile = "";
		outputProfile = getName() + "::" + getDateHired() + "::"; //+ Payment #.## + "::" + PART TIME/FULL TIME + all other payment stuff
	}
	@Override
	public boolean equals(Object obj) { //compare name, department and dateHired
		
	} 
}
