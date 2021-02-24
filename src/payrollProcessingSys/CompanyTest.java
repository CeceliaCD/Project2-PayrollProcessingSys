/**
 * 
 */
package payrollProcessingSys;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ceceliachollette-dickson, Nidaansari
 *
 */
public class CompanyTest {

	/**
	 * Test method for
	 * {@link payrollProcessingSys.Company#add(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testAdd() {
		Company comp = new Company();

		Profile prof = new Profile();
		prof.setName("Chollette,Cecelia");
		prof.setDept("CS");
		Date hired = new Date("2/29/2020");
		prof.setDateHired(hired);
		double SALARY = 80000.00;
		Fulltime fulltimer = new Fulltime(prof, 0, 0); ;
		fulltimer.setAnnualSalary(SALARY);
		assertTrue(comp.add(fulltimer)); // #1 case adding a fulltime employee to array

		Profile prof1 = new Profile();
		prof1.setName("Ansari,Nida");
		prof1.setDept("CS");
		Date hired1 = new Date("3/18/2013");
		prof1.setDateHired(hired1);
		double HOURLY_RATE = 45.9;
		Parttime parttimer = new Parttime(prof1, 0, 0, 0);
		parttimer.setHourlyRate(HOURLY_RATE);

		assertTrue(comp.add(parttimer)); // #2 case adding a partime employee to array

		Profile prof2 = new Profile();
		prof2.setName("Doe,John");
		prof2.setDept("IT");
		Date hired2 = new Date("3/18/2013");
		prof2.setDateHired(hired2);
		double SALARY1 = 95000.00;
		int DIRECTOR_ROLE = 3;
		Management manageRole3 = new Management(prof2, 0, 0, 0);
		manageRole3.setAnnualSalary(SALARY1);
		manageRole3.setRole(DIRECTOR_ROLE);
		assertTrue(comp.add(manageRole3)); // #3 case adding a management role (director) to array

		Profile prof3 = new Profile();
		prof3.setName("Doe,Jane");
		prof3.setDept("IT");
		Date hired3 = new Date("3/18/2013");
		prof3.setDateHired(hired3);
		double SALARY2 = 90000.00;
		int DEPARTMENT_HEAD_ROLE = 2;
		Management manageRole2 = new Management(prof3, 0, 0, 0);
		manageRole2.setAnnualSalary(SALARY2);
		manageRole2.setRole(DEPARTMENT_HEAD_ROLE);
		assertTrue(comp.add(manageRole2)); // #4 case adding a management role (department head) to array

		Profile prof4 = new Profile();
		prof4.setName("Brown,Charlie");
		prof4.setDept("ECE");
		Date hired4 = new Date("8/25/2005");
		prof4.setDateHired(hired4);
		double SALARY3 = 72000.00;
		int MANAGER_ROLE = 1;
		Management manageRole1 = new Management(prof4, 0, 0, 0);
		manageRole1.setAnnualSalary(SALARY3);
		manageRole1.setRole(MANAGER_ROLE);
		assertTrue(comp.add(manageRole1)); // #5 should be true (added in) because the grow() helper should allocate more
											// space in array

		Employee testerEmp = new Employee(prof, 1);

		assertFalse(comp.add(testerEmp)); // #6 should be false (not added in) because testerEmp has same profile as
											// fulltimer

		// fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link payrollProcessingSys.Company#remove(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testRemove() {
		// fail("Not yet implemented");
		Company comp = new Company();
		
		Profile prof = new Profile();
		prof.setName("Farmer,Peggy");
		prof.setDept("CS");
		Date hired = new Date("6/3/2020");
		prof.setDateHired(hired);
		double HOURLY_RATE = 38.70;
		Parttime parttimer = new Parttime(prof, 0, 0, 0); 
		parttimer.setHourlyRate(HOURLY_RATE);
		assertFalse(comp.remove(parttimer)); // #1 case: removing an employee that does not exist
		
		assertTrue(comp.add(parttimer));
		assertTrue(comp.remove(parttimer)); // #2 case: removing a parttime employee
		
		Profile prof2 = new Profile();
		prof2.setName("Styles,Harry");
		prof2.setDept("ECE");
		Date hired2 = new Date("2/1/2017");
		prof2.setDateHired(hired2);
		double SALARY = 75000.00;
		Fulltime fulltimer = new Fulltime(prof2, 0, 0); 
		fulltimer.setAnnualSalary(SALARY);
		assertTrue(comp.add(fulltimer));
		assertTrue(comp.remove(fulltimer)); // #3 case: removing a fulltime employee
		
		Profile prof3 = new Profile();
		prof3.setName("Smith,Bob");
		prof3.setDept("IT");
		Date hired3 = new Date("10/15/2012");
		prof3.setDateHired(hired3);
		double SALARY1 = 67000.00;
		int ROLE = 1;
		Management mngr = new Management(prof3, 0, 0, 0); 
		mngr.setAnnualSalary(SALARY1);
		mngr.setRole(ROLE);
		assertTrue(comp.add(mngr));
		assertTrue(comp.remove(mngr)); // #4 case: removing an employee with a management (manager) role
		
		Profile prof4 = new Profile();
		prof4.setName("Obama,Michelle");
		prof4.setDept("CS");
		Date hired4 = new Date("11/25/2015");
		prof4.setDateHired(hired4);
		double SALARY2 = 52700.00;
		int ROLE2 = 2;
		Management mngr2 = new Management(prof4, 0, 0, 0); 
		mngr2.setAnnualSalary(SALARY2);
		mngr2.setRole(ROLE2);
		assertTrue(comp.add(mngr2));
		assertTrue(comp.remove(mngr2)); // #4 case: removing an employee with a management (department head) role
		
		Profile prof5 = new Profile();
		prof5.setName("Obama,Barack");
		prof5.setDept("ECE");
		Date hired5 = new Date("4/8/2016");
		prof5.setDateHired(hired5);
		double SALARY3 = 94600.00;
		int ROLE3 = 3;
		Management mngr3 = new Management(prof5, 0, 0, 0); 
		mngr3.setAnnualSalary(SALARY3);
		mngr3.setRole(ROLE3);
		assertTrue(comp.add(mngr3));
		assertTrue(comp.remove(mngr3)); // #4 case: removing an employee with a management (director) role
	}

	/**
	 * Test method for
	 * {@link payrollProcessingSys.Company#setHours(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testSetHours() {
		Company comp = new Company();
		
		Profile prof = new Profile();
		prof.setName("Johnson,Janet");
		prof.setDept("ECE");
		Date hired = new Date("9/14/2019");
		prof.setDateHired(hired);
		double HOURLY_RATE = 42.00;
		int HOURS_WORKED = 82;
		Parttime parttimer = new Parttime(prof, 0, 0, 0); 
		parttimer.setHourlyRate(HOURLY_RATE);
		parttimer.setHoursWorked(HOURS_WORKED);
		assertFalse(comp.setHours(parttimer)); // #1 case: setting the hours of a parttime employee that does not exist
		
		Profile prof2 = new Profile();
		prof2.setName("Schmoe,Joe");
		prof2.setDept("IT");
		Date hired2 = new Date("5/23/2010");
		prof2.setDateHired(hired2);
		double HOURLY_RATE2 = 42.00;
		int HOURS_WORKED2 = 100;
		Parttime parttimer2 = new Parttime(prof2, 0, 0, 0);
		parttimer2.setHourlyRate(HOURLY_RATE2);
		parttimer2.setHoursWorked(HOURS_WORKED2);
		assertTrue(comp.add(parttimer2));
		assertTrue(comp.setHours(parttimer2)); // #2 case: setting the hours of a parttime employee that does exist
		// fail("Not yet implemented");
		
		Profile prof3 = new Profile();
		prof3.setName("Shaffer,Polly");
		prof3.setDept("CS");
		Date hired3 = new Date("8/1/2000");
		prof3.setDateHired(hired3);
		double HOURLY_RATE3 = 89.00;
		int HOURS_WORKED3 = -40;
		Parttime parttimer3 = new Parttime(prof3, 0, 0, 0);
		parttimer3.setHourlyRate(HOURLY_RATE3);
		parttimer3.setHoursWorked(HOURS_WORKED3);
		assertTrue(comp.add(parttimer3));
		assertFalse(comp.setHours(parttimer3)); // #3 case: setting the hours of a parttime employee to be negative
		
		Profile prof4 = new Profile();
		prof4.setName("Shaffer,Polly");
		prof4.setDept("ECE");
		Date hired4 = new Date("3/12/2004");
		prof4.setDateHired(hired4);
		double HOURLY_RATE4 = 65.50;
		int HOURS_WORKED4 = 102;
		Parttime parttimer4 = new Parttime(prof4, 0, 0, 0);
		parttimer4.setHourlyRate(HOURLY_RATE4);
		parttimer4.setHoursWorked(HOURS_WORKED4);
		assertTrue(comp.add(parttimer4));
		assertFalse(comp.setHours(parttimer4)); // #3 case: setting the hours of a parttime employee to be over 100
	}

}
