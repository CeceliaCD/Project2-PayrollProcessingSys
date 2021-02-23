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
		int capacity = 4;
		Employee[] eList = new Employee[capacity];
		
		Profile prof = new Profile();
		prof.setName("Chollette,Cecelia");
		prof.setDept( "CS");
		Date hired = new Date("2/13/2020");
		prof.setDateHired(hired);
		Fulltime fulltimer = new Fulltime(prof, 0, 80000.00);
		
		
		//Parttime parttimer = new Parttime();
		//Management manageRole = new Management();
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link payrollProcessingSys.Company#remove(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link payrollProcessingSys.Company#setHours(payrollProcessingSys.Employee)}.
	 */
	@Test
	public void testSetHours() {
		fail("Not yet implemented");
	}

}
