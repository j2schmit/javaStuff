/*
 * Employee.java
 */


/**
 * The Employee class extends the class of person for the particular case of an employed person!
 * @author Jeremy Schmitt
 */
public class Employee extends Person {

    private double hourlySalary;

    private double hoursWorked;

	/**
	 *
	 * Creates a new Employee with default values.
	 * @return  Employee object
	 */
	public Employee() {
		this("John Smith", 12.00, 0.0)
	}

	/**
	 *
	 * Creates a new Employee.
	 * @param   name           the name of the employee
     * @param   hourlySalary   the hourly salary of the employee
     * @param   hoursWorked    the number of hours worked by the employee
     * @return  Employee object
     */
	public Employee(String name, double hourlySalary, double hoursWorked) {
		super(name);
        this.hourlySalary = hourlySalary;
		this.hoursWorked = hoursWorked;
	}

	/**
	 * Access the hourly salary of the employee
	 * @return double the hourly salary of the employee
	 */
	public String getHourlySalary() {
		return hourlySalary;
	}

	/**
	 * Set the hourly salary of the employee
	 * @param  double  hourlySalary   the hourly salary of the employee
	 */
	public void setHourlySalary(double  hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	/**
	 * Access the hours worked by the employee
	 * @return double the hours worked by the employee
	 */
	public String getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * Set the hours worked by the employee
	 * @param  double  hoursWorked   the hours worked by the employee
	 */
	public void setHoursWorked(double  hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	/**
	 * Display the value of the attributes for a an instance
	 * @return String containing the value of the instance attributes
	 */
	@Override
	public void toString() {
		String str = super.toString();
		str += "Hourly Salary: " + hourlySalary + "\n";
		str += "Hours Worked: " + hoursWorked + "\n";
	}

}
