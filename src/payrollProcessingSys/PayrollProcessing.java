package payrollProcessingSys;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The PayrollProcessing class is responsible for majority of the input
 * exceptions, accepts command, and gives back the appropriate output for each.
 * Once the driver class is ran, it goes through this class with the following
 * commands.
 * @author Ceceliachollette-Dickson, Nidaansari
 */
public class PayrollProcessing {

	/**
	 * The run method is responsible for obtaining the input that the user gives in
	 * as a string and breaking it apart. First the command is obtained and based on
	 * that input, and whatever other input that should follow it, to discern the
	 * correct ouptut.
	 */
	public void run() {

		Scanner userInput = new Scanner(System.in);
		Company company = new Company();
		int numEmp = 0;

		System.out.println("Payroll Processing starts.");
		while (true) {

			String choice = userInput.nextLine();
			String[] command = choice.split(" ");
			String letter = command[0];

			if (letter.equals(" ")) {
				continue;
			}

			if (letter.equals("AP")) { // add a part time employee
				double wage = Double.parseDouble(command[4]);
				if (checkValid(new Date(command[3]), command[2]) == true && wage > 0) {
					Profile prof = setProfile(command[1], command[2], new Date(command[3]));
					Parttime parttimer = new Parttime(prof, 0, 0, 0);
					parttimer.setHourlyRate(wage);
					if (company.add(parttimer) == true) {
						System.out.println("Employee added.");
						numEmp++;
					} else {
						System.out.println("Employee is already on the list.");
					}
				} else if (wage < 0) {
					System.out.println("Pay rate cannot be negative.");
				}

			}

			else if (letter.equals("AF")) { // add a full time employee
				double salary = Double.parseDouble(command[4]);
				if (checkValid(new Date(command[3]), command[2]) == true && salary > 0) {
					Profile prof = setProfile(command[1], command[2], new Date(command[3]));
					Fulltime fulltimer = new Fulltime(prof, 0, 0);

					fulltimer.setAnnualSalary(salary);
					if (company.add(fulltimer) == true) {
						System.out.println("Employee added.");
						numEmp++;
					} else {
						System.out.println("Employee is already on the list.");
					}

				} else if (salary < 0) {
					System.out.println("Salary cannot be negative.");
				}
			}

			else if (letter.equals("AM")) { // add a full time manager
				int role = Integer.parseInt(command[5]);
				double salary = Double.parseDouble(command[4]);
				if (checkValid(new Date(command[3]), command[2]) == true && salary > 0) {
					if (role != 1 && role != 2 && role != 3) {
						System.out.println("Invalid management code.");
					} else {
						Profile prof = setProfile(command[1], command[2], new Date(command[3]));
						Management mngr = new Management(prof, 0, salary, 0);
						mngr.setRole(role);
						if (company.add(mngr) == true) {
							System.out.println("Employee added.");
							numEmp++;
						} else {
							System.out.println("Employee is already in the list.");
						}
					}
				} else if (salary < 0) {
					System.out.print("Salary cannot be negative.");
				}
			}

			else if (letter.equals("R")) { // remove an employee
				if (numEmp == 0) {
					System.out.println("Employee database is empty.");
				} else if (checkValid(new Date(command[3]), command[2]) == true) {
					Profile prof = setProfile(command[1], command[2], new Date(command[3]));
					Employee emp = new Employee(prof, 0);

					if (company.remove(emp) == true) {
						System.out.println("Employee removed.");
					} else {
						System.out.println("Employee does not exist.");
					}
				}
			}

			else if (letter.equals("C")) { // calculate payments for all employees
				if (numEmp == 0) {
					System.out.println("Employee database is empty.");
				} else {
					company.processPayments();
					System.out.println("Calculation of employee payments is done.");
				}
			}

			else if (letter.equals("S")) { // set the working hours
				int hours = Integer.parseInt(command[4]);
				if (numEmp == 0) {
					System.out.println("Employee database is empty.");
				} else if (checkValid(new Date(command[3]), command[2]) == true && hours <= 100 && hours > 0) {
					Profile prof = setProfile(command[1], command[2], new Date(command[3]));
					Parttime parttimer = new Parttime(prof, 0, 0, 0);
					parttimer.setHoursWorked(hours);
					if (company.setHours(parttimer) == true) {
						System.out.println("Working hours set.");
					} else {
						System.out.println("Employee does not exist.");
					}
				} else {
					if (hours > 100) {
					System.out.println("Invalid Hours: over 100.");
					}
					if (hours < 0) {
						System.out.println("Working hours cannot be negative.");
					}
				}
			}

			else if (letter.equals("PA")) { // print earning statements for all employees
				company.print();
			}

			else if (letter.equals("PH")) { // print in order of date hired
				company.printByDate();
			}

			else if (letter.equals("PD")) { // print grouped by department
				company.printByDepartment();
			}

			else if (letter.equals("Q")) {
				System.out.println("Payroll Processing Completed.");
				System.exit(0);
			} else {
				System.out.println("Command '" + letter + "' not supported!");
			}
		}
	}

	/**
	Setter method that sets the the attributes of a profile object
	for an employee.
	@param name is the name of employee
	@param dept is the employee's department 
	@param dateHired is the date that an employee was hired
	@return profile object
	*/
	public Profile setProfile(String name, String dept, Date dateHired) {
		Profile prof = new Profile();
		prof.setName(name);
		prof.setDept(dept);
		prof.setDateHired(dateHired);
		return prof;
	}

	/**
	Checks if the date and department name are valid dates and
	existing departments.
	@param date is the date given
	@param dept is a string name of their department
	@return true if they are valid, false otherwise
	*/
	public boolean checkValid(Date date, String dept) {
		if (date.isValid() == false) {
			System.out.println(date + " is not a valid date!");
			return false;
		} else if (!"CS".equals(dept) && !"ECE".equals(dept) && !"IT".equals(dept)) {
			System.out.println("'" + dept + "' is not a valid department code.");
			return false;
		}
		return true;
	}

}
