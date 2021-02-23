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

		while (true) {

			String choice = userInput.nextLine();
			String[] command = choice.split(" ");
			String letter = command[0];

			if (letter.equals("AP")) { // add a part time employee
				Date date = new Date(command[3]);
				if (date.isValid() == false) {
					System.out.println(date + " is not a valid date!");
				} else if (!"CS".equals(command[2]) && !"ECE".equals(command[2]) && !"IT".equals(command[2])) {
					System.out.println("Invalid department code.");
				} else {
					Profile prof = setProfile(command[1], command[2], date);
					Parttime parttimer = new Parttime(prof, 0, Double.parseDouble(command[4]), 0);
					if (company.add(parttimer) == true) {
						System.out.println("Employee added.");
					} else {
						System.out.println("Employee is already in the list.");
					}

				}
			}

			if (letter.equals("AF")) { // add a full time employee
				if (new Date(command[3]).isValid() == true) {
					Profile prof = setProfile(command[1], command[2], new Date(command[3]));
					Fulltime fulltimer = new Fulltime(prof, 0, Double.parseDouble(command[4]));

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
				Date date = new Date(command[3]);
				int role = Integer.parseInt(command[5]);
				if (date.isValid() == false) {
					System.out.println(date + " is not a valid date!");
				}
				// else if ();
				Profile prof = setProfile(command[1], command[2], date);
				Management parttimer = new Management(prof, 0, Double.parseDouble(command[4]), role, 0);

				if (company.add(parttimer) == true) {
					System.out.println("Employee added.");
				} else {
					System.out.println("Employee is already in the list.");
				}
			} else {
				System.out.println(date + " is not a valid date!");
			}

			if (letter.equals("R")) { // remove an employee
				if (new Date(command[3]).isValid() == true) {
					Profile prof = setProfile(command[1], command[2], new Date(command[3]));
					Employee emp = new Employee(prof, 0);

					if (company.remove(emp) == true) {
						System.out.println("Employee removed.");
					} else {
						System.out.println("Employee does not exist.");
					}
				} else {
					System.out.println("Invalid date!");
				}
			}
			

			if (letter.equals("C")) { // calculate payments for all employees
				company.processPayments();
				System.out.println("Calculation of employee payments is done.");
			}

			if (letter.equals("S")) { // set the working hours
				if (new Date(command[3]).isValid() == true) {
					Profile prof = setProfile(command[1], command[2], new Date(command[3]));
					Parttime parttimer = new Parttime(prof, 0, 0, 0);
					parttimer.setHoursWorked(Integer.parseInt(command[4]));

					if (company.setHours(parttimer) == true) {
						System.out.println("Working hours set.");
					} else {
						System.out.println("Employee does not exist.");
					}
				} else {
					System.out.println("Invalid date!");
				}
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
				System.exit(0);
			}

		}

	}

	public Profile setProfile(String name, String dept, Date dateHired) {
		Profile prof = new Profile();
		prof.setName(name);
		prof.setDept(dept);
		prof.setDateHired(dateHired);
		return prof;
	}
}
