/*
 * Employee.java
 */

/**
 *
 * @author Jeremy Schmitt
 */
public class Employee {
    
	// Name your member variables as follows: firstName, lastName and monthlySalary
	private String firstName;
	private String lastName;
	private double monthlySalary;

	// Implement a three-parameter constructor that takes, in order: the first name, last name and monthly salary

	public Employee(String f, String l, double m) {
		firstName = f;
		lastName = l;
		monthlySalary = m;
	}

	// Your accessor methods should be named following the pattern getVariableName. e.g.: getFirstName

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	// Your mutator methods should be named following the pattern setVariableName. e.g.: setFirstName

	public void setFirstName(String f) {
		firstName = f;
	}

	public void setLastName(String l) {
		lastName = l;
	}

	public void setMonthlySalary(double m) {
		if (m >= 0) {
		monthlySalary = m;
		}
	}

}
