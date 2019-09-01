/*
 * Person.java
 */


/**
 * The Person class represents a person via their name.
 * @author Jeremy Schmitt
 */

public class Person {
	
	private String name;  // A String for the name of the person

	/**
     * A no arg constructor for the class that uses default values
     * @return  Person object
     */
	public Person() {
		this("John Smith");
	}

	/**
     * A arg constructor for the class. 1 argument is required here, the name of the person.
	 * @param   name         the name of the person
     * @return  Person object
     */
	public Person(String name) {
		this.name = name;
	}	

	/**
	 * Access the name
	 * @return String containing the name of the person
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the person
	 * @param the name of the person
	 */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * This returns a string containing the value of the attributes
     * @return String contains the value of the attributes
     */
	@Override
	public String toString() {
		String str = "Person: " + name + "\n";
		return str;		
	}
}
