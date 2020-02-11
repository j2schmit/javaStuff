import java.io.*;

public class ObjectIO {

	private ObjectIO() {}

	public static void writeObject(Employee[] employees, String fileName) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(fileName));
 		oos.writeObject(employees);
	}

	public static void readObject(String fileName) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Employee[] employees = (Employee[]) ois.readObject();
		for (Employee employee: employees) {
			System.out.println(employee.toString());
		}
	}

}
