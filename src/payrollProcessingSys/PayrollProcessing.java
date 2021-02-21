package payrollProcessingSys;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
@author Ceceliachollette-Dickson, Nidaansari
*/
public class PayrollProcessing {
	
	/**
	 
	*/
	public void run() {
		
		Scanner userInput = new Scanner(System.in);
		Company company = new Company();
		
		//String commandLine = userInput.nextLine();
		//userInput.useDelimiter(" ");
		
		//while(userInput.hasNext(commandLine)) {
			//if(commandLine.equals("")) {
				//System.out.println("Command" + " '" + commandLine + "' not supported!");
			//}
			
		//}
		
		while (true) {

			String choice = userInput.nextLine();
			String[] command = choice.split(" ");
			String letter = command[0];

			if (letter.equals("AP")) { // add a part time employee
				//System.out.println("hello");
				String name = command[1];
				String dept = command[2];
				Date dateHired = new Date(command[3]);
				
				if (dateHired.isValid() == true) {
					Profile emp = new Profile();
					emp.setName(name);
					emp.setDepartment(dept);
					emp.setDateHired(dateHired);

				}
			}

			if (letter.equals("AF")) { // add a full time employee

			}
			
			if (letter.equals("AM")) { // add a full time manager

			}
			
			if (letter.equals("R")) { // remove an employee

			}
			
			if (letter.equals("C")) { //calculate payments for all employees

			}
			
			if (letter.equals("S")) { // set the working hours

			}
			
			if (letter.equals("PA")) { // print earning statements for all employees

			}
			
			if (letter.equals("PH")) { // print in order of date hired

			}
			
			if (letter.equals("PD")) { // print grouped by department

			}
			
			if (letter.equals("Q")) {
				System.out.println("Payroll Processing Completed.");
				System.exit(0);
			} 

		} 

	}
}
