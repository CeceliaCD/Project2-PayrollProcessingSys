package payrollProcessingSys;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Profile {
	private String name; //employees name in the form lastname,firstname
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
		return outputProfile;
	}
	
	// DOUBLE CHECK THIS @ NIDA
	@Override
	public boolean equals(Object obj) { //compare name, department and dateHired
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Profile)) {
			return false;
		}
		Profile objProfile = (Profile) obj;
		if (this.name.equals(objProfile.name) && 
				this.name.equals(objProfile.department) && this.name.equals(objProfile.dateHired)) {
			return true;
		}
		return false;
	} 
}
