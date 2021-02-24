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
public class ManagementTest {

	/**
	 * Test method for {@link payrollProcessingSys.Management#calculatePayment()}.
	 */
	@Test
	public void testCalculatePayment() {
		
		int manager = 1;
		int deptHead = 2;
		int director = 3;
		
		double annualSal = 72000.00;
		double payment = 2961.54;
		Profile prof = new Profile();
		prof.setName("Brown,Charlie");
		prof.setDept( "ECE");
		Date hired = new Date("8/25/2005");
		prof.setDateHired(hired);
		Management manageRole1 = new Management(prof, 0, annualSal, manager);
		Management expectedResult = new Management(prof, payment,  annualSal, manager);
		
		manageRole1.calculatePayment();
		assertEquals(manageRole1.getDollarValue(), expectedResult.getDollarValue()); //#1 testing if manager calculation works
		
		double annualSal1 = 94000.00;
		double payment1 = 3980.77;
		Profile prof1 = new Profile();
		prof1.setName("Jackson,Michael");
		prof1.setDept( "IT");
		Date hired1 = new Date("6/10/1998");
		prof1.setDateHired(hired1);
		Management manageRole2 = new Management(prof, 0, annualSal1, deptHead);
		Management expectedResult2 = new Management(prof, payment1,  annualSal1, deptHead);
		
		manageRole2.calculatePayment();
		assertEquals(manageRole2.getDollarValue(), expectedResult2.getDollarValue()); //#2 testing if department head calculation works
		
		double annualSal2 = 99000.00;
		double payment2 = 4269.23;
		Profile prof2 = new Profile();
		prof2.setName("Winfrey,Oprah");
		prof2.setDept( "CS");
		Date hired2 = new Date("11/13/1998");
		prof1.setDateHired(hired2);
		Management manageRole3 = new Management(prof2, 0, annualSal2, director);
		Management expectedResult3 = new Management(prof2, payment2,  annualSal2, director);
		
		manageRole3.calculatePayment();
		assertEquals(manageRole3.getDollarValue(), expectedResult3.getDollarValue()); //#3 testing if director calculation works
		
		//fail("Not yet implemented");
	}

}
