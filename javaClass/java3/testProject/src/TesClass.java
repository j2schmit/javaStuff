import java.util.ArrayList;
import java.util.List;

public class TesClass {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		System.out.println(list.get(0));
		Rock<Number> rock = new Rock<Number>();
	}

	public <T> T grow(T a) {

		return a;

	}
}
