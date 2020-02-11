import java.io.*;

/**
 *
 * This class executes the criterion for assignment 1 of Java IV:
 *
 * Using the skills you have learned related to Java I/O Streams in this lesson,
 * write a Java console application named Lesson1IOStream that (1) writes and then
 * (2) reads the following Employee object (as discussed in Lesson 1) the following ways:
 *
 * $ java Lesson1IOStream --help (displays help info)
 * $ java Lesson1IOStream --text (writes/reads as text file and displays results on console)
 * $ java Lesson1IOStream --binary (writes/reads as binary file and displays results on console)
 * $ java Lesson1IOStream --object (writes/reads as object file and displays results on console)
 *
 */

public class Lesson1IOStream {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        // Expects exactly one arguments
        if (args.length != 1) {
            displayHelpMessage();
            System.exit(1);
        }

        // Get user argument
        String cmd = args[0];

        String fileName;

        switch(cmd) {
            case "--help":
                displayHelpMessage();
                break;
            case "--text":
                fileName = System.getProperty("user.dir") + "/employees.txt";
                TextIO.writeText(getEmployees(), fileName);
                TextIO.readText(fileName);
                break;
            case "--binary":
                fileName = System.getProperty("user.dir") + "/employees.dat";
                BinaryIO.writeBinary(getEmployees(), fileName);
                BinaryIO.readBinary(fileName);
                break;
            case "--object":
                fileName = System.getProperty("user.dir") + "/employees.dat";
                ObjectIO.writeObject(getEmployees(), fileName);
                ObjectIO.readObject(fileName);
                break;
            default:
                displayHelpMessage();
        }
    }

    // Employees currently hardcoded. This method may be modified to prompt & receive employee data from the user.
    private static Employee[] getEmployees() {
        Employee[] employees = new Employee[2];
        employees[0] = new Employee("Donald Knuth", 250000.0, 1962, 3, 1);
        employees[1] = new Employee("Linus Torvalds", 10.0, 1994, 3, 14);
        return employees;
    }

    private static void displayHelpMessage() {
        String helpMsg = "Please provide 1 of the 4 following arguments:\n";
        helpMsg += "--help    display help message\n";
        helpMsg += "--text    reads/write as text file and displays results on console\n";
        helpMsg += "--binary  reads/writes as binary file and displays results on console\n";
        helpMsg += "--object  reads/writes as object file and displays results on console";
        System.out.println(helpMsg);
    }

}
