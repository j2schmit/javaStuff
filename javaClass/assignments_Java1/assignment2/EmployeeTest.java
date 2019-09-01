/*
 * EmployeeTest.java
 */

/**
 *
 * @author StudentName
 */
public class EmployeeTest {
    
    public static void main(String args[]){
        // Create two Employee objects
    	//	 Employee #1: Benjamin Bernanke has a monthly salary of 1234.56
    	//   Employee #2: Paul Volcker has a monthly salary of 2345.67
        
	Employee bBern = new Employee("Benjamin", "Bernanke", 1234.56);

	Employee pVolck = new Employee("Paul", "Volcker", 2345.67);

        // Display the employees' info (including yearly salary)
    	/* Note that you'll receive slightly different results for the salary displaying via printf and print/println.
    	 * This is due to the implicit precision and the rounding that is applied.
    	 * I used println, but you're welcome to use printf if you like: I account for slight variations in the numeric values displayed for the salaries.
    	 */

	String fB = bBern.getFirstName();
	String lB = bBern.getLastName();
	double mB = bBern.getMonthlySalary();

	System.out.println(fB + " " + lB +"\'s yearly salary: " + 12*mB);

	String fP = pVolck.getFirstName();
	String lP = pVolck.getLastName();
	double mP = pVolck.getMonthlySalary();

	System.out.println(fP + " " + lP +"\'s yearly salary: " + 12*mP);
       
        System.out.println("Giving raises...");

        // Give each employee a 10% raises.
    	// Be sure to actually apply the raise to the Employee objects: don't just calculate and display a 10% greater salary within this test code 

	bBern.setMonthlySalary(mB*1.1);

	pVolck.setMonthlySalary(mP*1.1);

	fB = bBern.getFirstName();
	lB = bBern.getLastName();
	mB = bBern.getMonthlySalary();

	System.out.println(fB + " " + lB +"\'s yearly salary: " + 12*mB);

	fP = pVolck.getFirstName();
	lP = pVolck.getLastName();
	mP = pVolck.getMonthlySalary();

	System.out.println(fP + " " + lP +"\'s yearly salary: " + 12*mP);
	
        // Display the employees' info (including yearly salary)
        
        System.out.println("Attempting to set a negative salary value...");
        // Attempt to set Bernanke's salary to a negative value...

	bBern.setMonthlySalary(mB*-1.1);

        // Display Bernanke's info (including yearly salary)

	fB = bBern.getFirstName();
	lB = bBern.getLastName();
	mB = bBern.getMonthlySalary();

	System.out.println(fB + " " + lB +"\'s yearly salary: " + 12*mB);

    }
    
}
