/*
 * Driver.java
 */


/*
 * This is the Driver class used to test the ExtensionCourse class and the subclass JavaCourse.
 * @author Jeremy Schmitt
 */
public class Driver {

	/**
     * Main method to execute the tasks of assignment 1 and 2
     */
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

		// Preparing to check if the toString Method and Copy Constructor are working
		System.out.println("\nLet's see if the copy constructor and toString method are working.\n");
 
		// Using toString to display info for introToFortran
		System.out.println(introToFortran);

		System.out.println("\nThe toString method seems to work.\n");

		ExtensionCourse copyIntroToFortran = new ExtensionCourse(introToFortran);

		System.out.println(copyIntroToFortran);

		System.out.println( copyIntroToFortran == introToFortran );

		System.out.println("\nIt looks like the copy constructor is working, since the objects contain the same info, but have different reference variables.");

		System.out.println("\nLet's see if the equals method is working.\n");

		System.out.println(introToFortran.equals(copyIntroToFortran));

		System.out.println("\nNailed it! Watch out Jeff Dean, I'm coming for your job!\n");

		// Course name is Java III
		courseName = "Java III";
		// The instructor is Joshua Bloch
		instructor = "Joshua Bloch";
		// 5 students have enrolled
		numberOfStudents = 5;
		// The course fee is $800
		courseFee = 800.0;
		// The IDE is IntelliJ
		String ide = "IntelliJ";

		//Creaing  subclasses
		JavaCourse java3 = new JavaCourse();
		java3.setCourseName(courseName);
		java3.setNumberOfStudents(numberOfStudents);
		java3.setInstructor(instructor);
		java3.setCourseFee(courseFee);
		java3.setIde(ide);

		// Displaying java3 info
		java3.display();

		// Course name is Java IV
		courseName = "Java IV";
		// The instructor is Satoshi Nakamoto
		instructor = "Satoshi Nakamoto";
		// 5,000,000 students have enrolled. A lot of people are excited to meet the instructor!
		numberOfStudents = 5000000;
		// The course fee is $80,000, and people are willing to pay!
		courseFee = 80000.0;
		// The IDE is NetBeans
		ide = "NetBeans";

		JavaCourse java4 = new JavaCourse(courseName, numberOfStudents, instructor, courseFee, ide);

		java4.display();

		// Creating array to hold all ExtensionCourse objects
		ExtensionCourse[] courses = {java1, java2, underWaterBasketWeaving, introToFortran, copyIntroToFortran, java3, java4};

		// Displaying all instance variable values for each ExtensionCourse object
		for (ExtensionCourse course: courses) {
			course.display();
		}

		ExtensionCourse.displayCounter();
	}

}
