import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TextIO {

    private TextIO() {}

    public static void writeText(Employee[] employees, String fileName) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        for (Employee employee: employees) {
            printWriter.println(employee);
        }
        printWriter.close();
    }

    public static void readText(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        List<String> employeeStrings = Files.readAllLines(filePath);
        for (String employeeString: employeeStrings) {
            System.out.println(employeeString);
        }
    }

}
