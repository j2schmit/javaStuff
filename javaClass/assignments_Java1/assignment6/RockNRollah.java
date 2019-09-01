/*
 * RockNRollah.java
 */

import java.util.Random;

/**
 *
 * @author StudentName
 */
public class RockNRollah {
       
    public static void main(String[] args) {
    	// Create a Random object

	Random random = new Random();

    	// Initialize a couple of variables to hold the values of the two dice

	int dice1;
	int dice2;

	int rolls = 36000000;

    	// Initialize the array that will hold the results

	int[] diceValues = {0,0,0,0,0,0,0,0,0,0,0,0,0};

    	/* Hypothetical questions: (no, I don't want answers)
    	 *   How many different sum values do we need to account for?
    	 *   How big does the array need to be?
    	 *   Why might you make it (slightly) larger? (Note: my answer does not use an unnecessarily large array, and I'm not encouraging you to; just giving you something to think about) 
    	 */
    	// Roll the dice (a lot) and sum and tally the results

	for (int j = 1; j <= rolls; j++) {

		dice1 = random.nextInt(6) + 1;
		dice2 = random.nextInt(6) + 1;

		diceValues[dice1 + dice2] += 1;

	}
        // Display the frequencies
        System.out.println("Results after " + rolls + " rolls");
        System.out.println("-------------------------");
        System.out.println("Value\tFrequency");
        // Loop, displaying the rows for the body of the table, each on its own line.
        //   The required format for each row is to display the sum, followed by a tab, followed by the number of times that sum came up. Do not include any additional formatting

	for (int i = 2; i <= 12; i++) {
	
	System.out.println(i + "\t" + diceValues[i]);

	}
    }
    
}
