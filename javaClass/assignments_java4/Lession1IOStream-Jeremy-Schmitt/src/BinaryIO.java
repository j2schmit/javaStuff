import java.io.*;
import java.time.*;

public class BinaryIO {

    private BinaryIO() {}

    public static void writeBinary(Employee[] employees, String fileName) throws IOException {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(fileName));
        for (Employee employee: employees) {
            writeEmployeeToBinary(employee, writer);
        }
        writer.close();
    }

    public static void writeEmployeeToBinary(Employee employee, DataOutput writer) throws IOException {
        // Using a divider to separate the fields of the employee. This divider is assumed when reading in the employee.
        char divider = '|';
        for (char character: employee.getName().toCharArray()) {
            writer.writeChar(character);
        }
        writer.writeChar(divider);

        writer.writeDouble(employee.getSalary());
        writer.writeChar(divider);

        LocalDate hireDate = employee.getHireDate();
        writer.writeInt(hireDate.getYear());
        writer.writeInt(hireDate.getMonthValue());
        writer.writeInt(hireDate.getDayOfMonth());
    }

    public static void readBinary(String fileName) throws IOException{
        RandomAccessFile reader = new RandomAccessFile(fileName, "r");
        Employee employee;
        while (true) {
            try {
                employee = readEmployeeFromBinary(reader);
                System.out.println(employee.toString());
            } catch (EOFException e) {
                break;
            }
        }
        reader.close();
    }

    public static Employee readEmployeeFromBinary(RandomAccessFile reader) throws IOException {
        StringBuilder nameBuilder = new StringBuilder();
        char letter = reader.readChar();
        while (letter != '|') {
            nameBuilder.append(letter);
            letter = reader.readChar();
        }
        String name = nameBuilder.toString();

        double salary = reader.readDouble();
        reader.readChar();

        int year = reader.readInt();
        int month = reader.readInt();
        int dayOfMonth = reader.readInt();

        return new Employee(name, salary, year, month, dayOfMonth);
    }
}
