
import java.io.*;
import java.time.*;

public class Employee  implements Serializable {

    private String name;
    private double salary;
    private LocalDate hireDate;

    public Employee(String name, double salary, int hireYear, int hireMonth, int hireDayOfMonth) {
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(hireYear, hireMonth, hireDayOfMonth);
    }

    public String getName() { return name; }

    public double getSalary() { return salary; }

    public LocalDate getHireDate() { return hireDate; }

    public String toString() { return getName() + " | " + getSalary() + " | " + getHireDate().toString(); }

}
