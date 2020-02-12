import java.util.Scanner;
import java.io.*;

/**
 *
 * This class executes the functionality required for Lesson 2 of Java 4.
 *
 * Using the skills you have learned related to Java Regular Expressions in this lesson,
 * write a Java console application named Lesson2RegEx that reads in the attached file (neighbor-dump.txt)
 * and uses Regular Expressions to generate the following output:
 *
 * $ java Lesson2RegEx neighbor-dump.txt
 * Processed the following input file:
 * neighbor-dump.txt
 * Results are as follows:
 * - List of PAN IDs (Total of 2)
 * PANID = 04fa
 * PANID = 329d
 * - List of MAC Addresses (Total of 4)
 *
 * 000781fe0000326f
 * 000781fe0000614e
 * 000781fe00002f76
 * 000781fe0000313e
 *
 * - List of RF_RSSI_M values for each MAC address
 *
 * 000781fe0000326f -51.984
 * 000781fe0000614e -24.294
 * 000781fe00002f76 -25.5
 * 000781fe0000313e -36.953
 *
 */

public class Lesson2RegEx {

    public static void main(String[] args) {
        String fileName = "neighbor-dump.txt";

        RegexProcessor regexProcessor = new RegexProcessor();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Scanner scanner = new Scanner(fileInputStream);
            while(scanner.hasNextLine())  {
                regexProcessor.processLine(scanner.nextLine());
            }
            scanner.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Processed the following input file:");
        System.out.println(fileName);
        System.out.println("Results are as follows:");
        PrettyPrinter.prettyPrintResults(regexProcessor);
    }

}
