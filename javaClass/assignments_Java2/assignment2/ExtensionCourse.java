/*
 * ExtensionCourse.java
 */


/**
 * The ExtensionCourse class represents one of my favorite objects, a UCSD Extension course!
 * @author Jeremy Schmitt
 */

// UCSD Extension course class
public class ExtensionCourse {

	
	public static int counter = 0;  // An integer that counts the number of instances of the class
	
	private String courseName;  // A String for the name of the course
	
	private int numberOfStudents;   // An integer for the number of students enrolled in the course
	
	private String instructor;  // A String for the name of the instructor
	
	private double courseFee;   // A double for the cost to enroll in the course


	/**
     * A no arg constructor for the class that uses default values
     * @return  ExtensionCourse object
     */
	public ExtensionCourse() {
		this("Some Course", 0, "You", 0);
	}

	/**
     * A arg constructor for the class. 4 arguments are required here, consisting of the instance variables above.
	 * @param   courseName         the name of the course
     * @param   numberOfStudents   the number of students enrolled
     * @param   instructor         the name of the course instructor
     * @param   courseFee          the amount of the course fee in dollars
     * @return  ExtensionCourse object
     */
	public ExtensionCourse(String courseName, int numberOfStudents, String instructor, double courseFee) {
		this.courseName = courseName;
		this.numberOfStudents = numberOfStudents;
		this.instructor = instructor;
		this.courseFee = courseFee;
		counter++;
	}

    /**
     * A deep copy of an ExtensionCourse object
     * @param ExtensionCourse to be copied
     * @return ExtensionCourse a deep copy of the ExtensionCourse
     */
	public ExtensionCourse( ExtensionCourse extensionCourse ) {
		this.courseName = extensionCourse.courseName;
		this.numberOfStudents = extensionCourse.numberOfStudents;
		this.instructor = extensionCourse.instructor;
		this.courseFee = extensionCourse.courseFee;
		counter++;
	}	

	/**
	 * Access the course name
	 * @return String containing the name of the course
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Access the number of enrolled students
	 * @return int number of enrolled students
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	/**
	 * Access the name of the instructor
	 * @return String containing the name of the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * Access the course fee
	 * @return double containing the amount of the course fee
	 */
	public double getCourseFee() {
		return courseFee;
	}

	/**
	 * Set the name of the course
	 * @param   courseName   the name of the course
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Set the number of students enrolled
	 * @param   numberOfStudents   the number of students enrolled
	 */
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	/**
	 * Set the name of the instructor
	 * @param   instructor   the name of the instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * Set the course fee
	 * @param   courseFee   the amount of the course fee in dollars
	 */
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

    /**
     * An incrementor to increase the (static) count of enrolled students
     */
	public void addStudent() {
		this.numberOfStudents++;
	}

    /**
     * Display the value of the attributes
     */
	public void display() {
		System.out.println("\nCourse: " + courseName);
		System.out.println("Instructor: " + instructor);
		System.out.println("Course Fee: $" + courseFee);
		System.out.println("Enrolled Students: " + numberOfStudents);
	}

    /**
     * This returns a string containing the value of the attributes
     * @return String contains the value of the attributes
     */
	@Override
	public String toString() {
		String str = "Course: " + courseName + "\n";
		str += "Instructor: " + instructor + "\n";
		str += "Course Fee: $" + courseFee + "\n";
		str += "Enrolled Students: " + numberOfStudents;
		return str;		
	}

    /**
     * Method for defining equality between this instance and a given ExtensionCourse when they have the same attribute values
     * @param extensionCourse an extensionCourse to be compared with
     * @return boolean true if equal in the above sense, false otherwise
     */
	public boolean equals(ExtensionCourse extensionCourse) {
		if (courseName.equals(extensionCourse.courseName) && instructor.equals(extensionCourse.instructor) && (courseFee == extensionCourse.courseFee) && (numberOfStudents == extensionCourse.numberOfStudents)) {
			return true;
		} else {
			return false;
		}
	}
 
    /**
     * Display the number of instances of Extension Courses created
     */
	public static void displayCounter() {
		System.out.println("Number of instances: " + counter);
	}

}
