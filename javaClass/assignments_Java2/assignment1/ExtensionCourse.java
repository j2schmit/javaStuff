/*
 * ExtensionCourse.java
 */


/**
 * The ExtensionCourse class represents one of my favorite objects, a UCSD Extension course!
 * @author Jeremy Schmitt
 */

// UCSD Extension course class
public class ExtensionCourse {
	// A String for the name of the course
	private String courseName;
	// An integer for the number of students enrolled in the course
	private int numberOfStudents;
	// A String for the name of the instructor
	private String instructor;
	// A double for the cost to enroll in the course
	private double courseFee;
	// A no arg constructor for the class
	public ExtensionCourse() {
	}
	// A arg constructor for the class. 4 arguments are required here, consisting of the instance variables above.
	public ExtensionCourse(String courseName, int numberOfStudents, String instructor, double courseFee) {
		this.courseName = courseName;
		this.numberOfStudents = numberOfStudents;
		this.instructor = instructor;
		this.courseFee = courseFee;
	}
	// Accessor method for the course name
	public String getCourseName() {
		return courseName;
	}
	// Accessor method for the number of students enrolled in the course
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	// Accessor method for the name of the instructor
	public String getInstructor() {
		return instructor;
	}
	// Accessor method to get the course fee
	public double getCourseFee() {
		return courseFee;
	}
	// Mutator method to set the course name
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	// Mutator method to set the number of students enrolled in the course
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	// Mutator method to set the name of the instructor
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	// Mutator method to set the course fee
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	// Method to increment the number of students enrolled by one
	public void addStudent() {
		this.numberOfStudents++;
	}
	// Method to display all 4 instance variable values
	public void display() {
		System.out.println("Course: " + courseName);
		System.out.println("Instructor: " + instructor);
		System.out.println("Course Fee: $" + courseFee);
		System.out.println("Enrolled Students: " + numberOfStudents + "\n");
	}

}
