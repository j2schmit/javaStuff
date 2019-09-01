/*
 * JavaCourse.java
 */


/**
 * The JavaCourse class extends the class of UCSD Extension courses for the particular case of a Java course!
 * @author Jeremy Schmitt
 */
public class JavaCourse extends ExtensionCourse {

	private String ide; // Course IDE attribute

	/**
	 *
	 * Creates a new Java Course with default values.
	 * @return  JavaCourse object
	 */
	public JavaCourse() {
		super();
		this.ide = "Eclipse";
	}

	/**
	 *
	 * Creates a new Java Course.
	 * @param   courseName         the name of the course
     * @param   numberOfStudents   the number of students enrolled
     * @param   instructor         the name of the course instructor
     * @param   courseFee          the amount of the course fee in dollars
     * @param   ide                the IDE used for the course
     * @return  JavaCourse object
     */
	public JavaCourse(String courseName, int numberOfStudents, String instructor, double courseFee, String ide) {
		super(courseName, numberOfStudents, instructor, courseFee);
		this.ide = ide;
	}

	/**
	 * Access the course IDE name
	 * @return String containing the name of the course IDE
	 */
	public String getIde() {
		return ide;
	}

	/**
	 * Set the name of the course IDE
	 * @param   ide   the name of the course IDE
	 */
	public void setIde(String ide) {
		this.ide = ide;
	}

	/**
	 * Display the value of the attributes for a an instance
	 * @return String containing the value of the instance attributes
	 */
	@Override
	public void display() {
		super.display();
		System.out.println("Course IDE: " + ide);
	}

}
