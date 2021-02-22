package payrollProcessingSys;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Ceceliachollette-Dickson, Nidaansari
 */
public class PayrollProcessing {

	/**
	 
	*/
	public void run() {

		Scanner userInput = new Scanner(System.in);
		Company company = new Company();

		// String commandLine = userInput.nextLine();
		// userInput.useDelimiter(" ");

		// while(userInput.hasNext(commandLine)) {
		// if(commandLine.equals("")) {
		// System.out.println("Command" + " '" + commandLine + "' not supported!");
		// }

		// }

		while (true) {

			String choice = userInput.nextLine();
			String[] command = choice.split(" ");
			String letter = command[0];

			if (letter.equals("AP")) { // add a part time employee
				String name = command[1];
				String dept = command[2];
				Date dateHired = new Date(command[3]);
				double wage = Double.parseDouble(command[4]);

				if (dateHired.isValid() == true) {
					Profile prof = new Profile();
					prof.setName(name);
					prof.setDepartment(dept);
					prof.setDateHired(dateHired);
					Parttime parttimer = new Parttime(prof, 0, wage, 0);

					//if (company.add(parttimer) == true) {
						System.out.println("add: " + company.add(parttimer));
						System.out.println("Employee added.");
						System.out.println("partime: " + parttimer);
					//} else {
					//	System.out.println("Employee is already in the list");
					//}
				} else {
					System.out.println("Invalid date!");
				}
			}

			if (letter.equals("AF")) { // add a full time employee
				String name = command[1];
				String dept = command[2];
				Date dateHired = new Date(command[3]);
				double salary = Double.parseDouble(command[4]);

				if (dateHired.isValid() == true) {
					Profile prof = new Profile();
					prof.setName(name);
					prof.setDepartment(dept);
					prof.setDateHired(dateHired);
					Fulltime fulltimer = new Fulltime(prof, 0, salary);

					if (company.add(fulltimer) == true) {
						System.out.println("Employee added.");
					} else {
						System.out.println("Employee is already in the list");
					}
				} else {
					System.out.println("Invalid date!");
				}
			}

			if (letter.equals("AM")) { // add a full time manager

			}

			if (letter.equals("R")) { // remove an employee

			}

			if (letter.equals("C")) { // calculate payments for all employees

			}

			if (letter.equals("S")) { // set the working hours

			}

			if (letter.equals("PA")) { // print earning statements for all employees
				company.print();
			}

			if (letter.equals("PH")) { // print in order of date hired
				company.printByDate();
			}

			if (letter.equals("PD")) { // print grouped by department
				company.printByDepartment();
			}

			if (letter.equals("Q")) {
				System.out.println("Payroll Processing Completed.");
				System.exit(0); // change this
			}

		}

	}
}
