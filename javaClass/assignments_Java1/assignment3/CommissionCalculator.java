/*
 * CommissionCalculator.java
 */

import java.util.Scanner;

/**
 *
 * @author Jeremy Schmitt
 */

public class CommissionCalculator {
    
    public static void main(String args[]) {
        // Initialize a Scanner to read input from the command line
    	
	Scanner input = new Scanner(System.in);

    	/* Note that we'll be doing this at least once and most likely multiple times...
    	 * Prompt the user with a menu of the four items and their values (this information is included in the problem statement)
    	 */

    	System.out.println("Item\tValue");
        System.out.println("1\t$239.99");
        System.out.println("2\t$129.75");
        System.out.println("3\t$99.95");
        System.out.println("4\t$350.89"); 

    	/* Display the user's current compensation
    	 * 
    	 * Prompt and take input from the user (you may assume that they will only enter int values)
    	 * They'll enter an item number (1 - 4) to record its sale or 0 to exit
    	 * 
    	 * NOTE: THE USER DOES NOT ENTER PRICES DIRECTLY... THEY ENTER ITEM NUMBERS TO INDICATE WHAT WAS SOLD
    	 * NOTE: THE USER MAY ENTER THE SAME ITEM NUMBRER MULTIPLE TIMES
    	 * 
    	 * If the user provides invalid input (a value other than 0 - 4) display "ERROR: Invalid input!" and prompt them again
    	 */

	double compensation = 200;    	

	System.out.printf("Current compensation: $%.2f%n", compensation);
	System.out.print("Please select an item from the list above (or enter 0 to exit): ");

	int item = input.nextInt();

	while ( item != 0 ) {
		if ( item == 1 ) {
			compensation += 239.99 * 0.09;
		}
		else if ( item == 2) {
			compensation += 129.75 * 0.09;
		}
		else if ( item == 3) {
			compensation += 99.95 * 0.09;
		}
		else if ( item == 4) {
			compensation += 350.89 * 0.09;
		}
		else {
			System.out.println("ERROR: Invalid input!");
		}
		
    		System.out.println("Item\tValue");
        	System.out.println("1\t$239.99");
        	System.out.println("2\t$129.75");
        	System.out.println("3\t$99.95");
        	System.out.println("4\t$350.89");

		System.out.printf("Current compensation: $%.2f%n", compensation);
		System.out.print("Please select an item from the list above (or enter 0 to exit): ");

		item = input.nextInt();
	}


    	/* After the user enters 0, display the salesperson's earnings in the format "Total earnings: $NNN.NN" and exit
    	 * For example, if the salesperson sold two item 3s this week the final output would be "Total earnings: $217.99"
    	 */

	System.out.printf("Total earnings: $%.2f%n", compensation);
    }
    
}
