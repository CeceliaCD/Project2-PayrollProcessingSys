package payrollProcessingSys;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Profile {
	private String name; //employees name in the form lastname,firstname
	private String department; //department code: CS, ECE, IT
	private Date dateHired;
	
	public String getName() { //setters are not needed since variables are supposed to be immutable
		return name;
	}
	
	public String getDept() { //setters are not needed since variables are supposed to be immutable
		return department;
	}
	
	public Date getDateHired() { //setters are not needed since variables are supposed to be immutable
		return dateHired;
	}
	
	@Override
	public String toString() { 
		String outputProfile = "";
		outputProfile = getName() + "::" + getDept() + "::" + getDateHired(); //+ Payment #.## + "::" + PART TIME/FULL TIME + all other payment stuff
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
				this.department.equals(objProfile.department) && this.dateHired.equals(objProfile.dateHired)) {
			return true;
		}
		return false;
	} 
}
