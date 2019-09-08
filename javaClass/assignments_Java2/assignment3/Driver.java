/*
 * Driver.java
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.*;
import java.lang.ClassCastException;

/*
 *
 * I have utilized logging and generics in this class.
 *
 * LOGGING --
 * For logging see the file 'output.log'.
 * NOTE: I suppressed logging to stdout, as it clutters up output.
 *
 * GENERICS --
 * A generic method has been constructed that when given a collection of
 * Employee instances and the name of an attribute, it will return an
 * ArrayList of the attribute values for all instances in the collection.
 * To demonstrate this the Name and HourlySalary attributes have been used to
 * return the first Name (via alphabetical ordering) and the largest
 * HourlySalary.
 *
 * Exception handling is only used via throws.
 * I did not create a custom exception.
 * For storing the employee objects I have used a LinkedList as the collection.
 *
 * @author Jeremy Schmitt
 */
public class Driver {

	private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

    /**
     * Main method to execute the tasks of assignment 3
     */
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// Setting output file for logging
		FileHandler fh = new FileHandler("output.log");
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		LOGGER.addHandler(fh);
		LOGGER.setUseParentHandlers(false);

		LOGGER.info("Prompting user for info.");
		System.out.println("How many employees do you have?");

		Scanner input = new Scanner(System.in);

		int numberOfEmployees = Integer.parseInt(input.nextLine().trim());
		LOGGER.info("Number of employees: " + numberOfEmployees);

		String employeeName;
		double hourlySalary;
		double hoursWorked;
		LinkedList<Employee> employees = new LinkedList<Employee>();

		for (int i = 1; i<=numberOfEmployees; i++) {
			System.out.println("Please provide the name of this employee: ");
			employeeName = input.nextLine();
			LOGGER.info("Employee Name: " + employeeName);

			System.out.println("Please provide the hourly salary for " + employeeName + ": ");
			hourlySalary = Double.parseDouble(input.nextLine().trim());
			LOGGER.info("Hourly Salary: " + hourlySalary);

			System.out.println("Please provide the hours worked by " + employeeName + ": ");
			hoursWorked = Double.parseDouble(input.nextLine().trim());
			LOGGER.info("Hours Worked: " + hoursWorked);

			employees.add(new Employee(employeeName, hourlySalary, hoursWorked));
			LOGGER.info("Employee added to LinkedList.");
		}

		printSalaryReport(employees);
		LOGGER.info("Employees info exported to csv.");

		ArrayList<String> names = new ArrayList<String>();
		names = getListOfValues(employees, "name");
		Collections.sort(names);
		System.out.println("The first name (alphabetically) is: " + names.get(0));

		ArrayList<Double> hourlySalaries = new ArrayList<Double>();
		hourlySalaries = getListOfValues(employees, "hourlySalary");
		Collections.sort(hourlySalaries);
		Collections.reverse(hourlySalaries);
		System.out.println("The largest hourly salary is: $" + hourlySalaries.get(0));
	}

	/**
	 * This method creates a CSV file of the employee info
	 * @param employees a LinkedList of employee instances
	 * @return void
	 */
	public static void printSalaryReport(LinkedList<Employee> employees) throws FileNotFoundException{
		double hourlySalary;
		double hoursWorked;
		File file = new File("employee.csv");
		PrintWriter printWriter = new PrintWriter(file);
		for (Employee employee : employees) {
			hourlySalary = employee.getHourlySalary();
			hoursWorked = employee.getHoursWorked();
			printWriter.println(employee.getName()+", "+hourlySalary+", "+hoursWorked+", "+hourlySalary*hoursWorked);
		}
		printWriter.close();
	}

	/* Suppressing unchecked type warning, as I am preventing null values.
	   Might be a little sketchy :).
	   This is a clear example of the difference in type handling between python & java.
	   What would be natural for a python dictionary is problematic for java.
	*/
	/**
	 * This generic method returns an ArrayList of the specificied attribute for
	 * all employee instances in the LinkedList.
	 * @param employees a LinkedList of employee instances
	 * @param valueType a String specifying the attributes
	 * @return ArrayList
	 */
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> getListOfValues(LinkedList<Employee> employees, String valueType) {
		ArrayList<T> values = new ArrayList<T>();
		for (Employee employee : employees) {
			if (employee.getMap().get(valueType) != null) {
				values.add((T) employee.getMap().get(valueType));
			}
		}
		return values;
	}

}
