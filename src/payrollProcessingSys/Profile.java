package payrollProcessingSys;

/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class Profile {
	private String name; //employees name in the form lastname,firstname
	private String department; //department code: CS, ECE, IT
	private Date dateHired;
	
	/**
	@return 
	*/
	public String getName() { 
		return name;
	}
	
	/**
	@return 
	*/
	public String getDept() { 
		return department;
	}
	
	/**
	@return
	*/
	public Date getDateHired() { 
		return dateHired;
	}
	
	/**
	@param
	*/
	public void setName(String empName) {
		this.name = empName;
	}
	
	/**
	@param
	*/
	public void setDept(String dept) {
		this.department = dept;
	}
	
	/**
	@param 
	*/
	public void setDateHired(Date hired) {
		this.dateHired = hired;
	}
	
	/**
	@return 
	*/
	@Override
	public String toString() { 
		return getName() + "::" + getDept() + "::" + getDateHired().toString();
	}
	
	/**
	@param
	@return 
	*/
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
				this.department.equals(objProfile.department)&& objProfile.dateHired.getYear()==this.dateHired.getYear()
	                    && objProfile.dateHired.getMonth()==this.dateHired.getMonth() && objProfile.dateHired.getDay()==this.dateHired.getDay()) {
			return true;
		}
		return false;
	} 
}
