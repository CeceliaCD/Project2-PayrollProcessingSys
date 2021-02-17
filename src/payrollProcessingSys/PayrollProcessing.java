package payrollProcessingSys;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {
	
	public void run() {
		
		Scanner userInput = new Scanner(System.in);
		Company company = new Company();
		
		String commandLine = userInput.nextLine();
		userInput.useDelimiter(" ");
		
		while(userInput.hasNext(commandLine)) {
			if(commandLine.equals("")) {
				System.out.println("Command" + " '" + commandLine + "' not supported!");
			}
			
		}
		
		
	}

}
