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
	 * Test method for {@link payrollProcessingSys.Company#add(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testAdd() {
		Company comp = new Company();
		
		Profile prof = new Profile();
		prof.setName("Chollette,Cecelia");
		prof.setDept( "CS");
		Date hired = new Date("2/29/2020");
		prof.setDateHired(hired);
		Fulltime fulltimer = new Fulltime(prof, 0, 80000.00);
		
		assertTrue(comp.add(fulltimer)); //#1 case adding a fulltime employee to array
		
		Profile prof1 = new Profile();
		prof1.setName("Ansari,Nida");
		prof1.setDept( "CS");
		Date hired1 = new Date("3/18/2013");
		prof1.setDateHired(hired1);
		Parttime parttimer = new Parttime(prof1, 0, 45.9, 0); 
		
		assertTrue(comp.add(parttimer)); //#2 case adding a partime employee to array
		
		Profile prof2 = new Profile();
		prof2.setName("Doe,John");
		prof2.setDept( "IT");
		Date hired2 = new Date("3/18/2013");
		prof2.setDateHired(hired2);
		Management manageRole3 = new Management(prof2, 0, 95000.00, 3); 
		
		assertTrue(comp.add(manageRole3)); //#3 case adding a management role (director) to array
		
		Profile prof3 = new Profile();
		prof3.setName("Doe,Jane");
		prof3.setDept( "IT");
		Date hired3 = new Date("3/18/2013");
		prof3.setDateHired(hired3);
		Management manageRole2 = new Management(prof3, 0, 90000.00, 2); 
		
		assertTrue(comp.add(manageRole2)); //#4 case adding a management role (department head) to array
		
		Profile prof4 = new Profile();
		prof4.setName("Brown,Charlie");
		prof4.setDept( "ECE");
		Date hired4 = new Date("8/25/2005");
		prof4.setDateHired(hired4);
		Management manageRole1 = new Management(prof4, 0, 72000.00, 1); 
		
		assertTrue(comp.add(manageRole1)); //#5 should be true (added in) because the grow() helper she allocate mroe space in array
		
		Employee testerEmp = new Employee(prof, 1);
		
		assertFalse(comp.add(testerEmp)); //#6 should be false (not added in) because testerEmp has same profile as fulltimer
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link payrollProcessingSys.Company#remove(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testRemove() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link payrollProcessingSys.Company#setHours(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testSetHours() {
		//fail("Not yet implemented");
	}

}
