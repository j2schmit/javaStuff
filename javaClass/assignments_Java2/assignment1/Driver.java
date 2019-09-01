/*
 * Driver.java
 */


/*
 * This is the Driver class used to test the ExtensionCourse class.
 * @author Jeremy Schmitt
 */

public class Driver {
	// Main method constructs 4 ExtensionCourse objects and displays their instance variable values
	public static void main(String[] args) {
		// Course name is Java I
		String courseName = "Java I";
		// The instructor's name is Godfrey Duke
		String instructor = "Godfrey Duke";
		// The number of students enrolled is 30
		int numberOfStudents = 30;
		// The course fee is $800
		double courseFee = 800.0;

		// Constructing ExtensionCourse java1 using no arg constructor and setting instance variable values
		ExtensionCourse java1 = new ExtensionCourse();
		java1.setCourseName(courseName);
		java1.setNumberOfStudents(numberOfStudents);
		java1.setInstructor(instructor);
		java1.setCourseFee(courseFee);

		// Course name is Java II
		courseName = "Java II";
		// The instructor's name is James Gappy
		instructor = "James Gappy";
		// The number of students enrolled is 12
		numberOfStudents = 12;
		// The course fee is $800
		courseFee = 800.0;

		// Constructing ExtensionCourse java2 using no arg constructor and setting instance variable values
		ExtensionCourse java2 = new ExtensionCourse();
		java2.setCourseName(courseName);
		java2.setNumberOfStudents(numberOfStudents);
		java2.setInstructor(instructor);
		java2.setCourseFee(courseFee);

		// Course name is Underwater Basket Weaving, one of the more popular extension courses
		courseName = "Underwater Basket Weaving";
		// The instructor's name is Aqua Man
		instructor = "Aqua Man";
		// The number of students enrolled is 100,000
		numberOfStudents = 100000;
		// The course fee is $1024
		courseFee = 1024.0;

		// Constructing ExtensionCourse underWaterBasketWeaving using the arg constructor
		ExtensionCourse underWaterBasketWeaving = new ExtensionCourse(courseName, numberOfStudents, instructor, courseFee);

		// Course name is Intro to Fortran, which has been havng enrollment problems lately
		courseName = "Intro to Fortran";
		// The instructor is the legendary Donald Kneuth
		instructor = "Donald Kneuth";
		// Sadly, no students have enrolled so far
		numberOfStudents = 0;
		// The course fee has been lowered to attract students
		courseFee = 20.0;

		// Constructing ExtensionCourse introToFortran using the arg constructor
		ExtensionCourse introToFortran = new ExtensionCourse(courseName, numberOfStudents, instructor, courseFee);

		// One student has enrolled!
		introToFortran.addStudent();

		// Creating array to hold all ExtensionCourse objects
		ExtensionCourse[] courses = {java1, java2, underWaterBasketWeaving, introToFortran};

		// Displaying all instance variable values for each ExtensionCourse object
		for (ExtensionCourse course: courses) {
			course.display();
		}

	}

}
