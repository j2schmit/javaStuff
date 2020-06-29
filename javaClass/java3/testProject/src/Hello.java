import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hello<T> {
	T t;
	public Hello(T t) {
		this.t = t;
	}
	public T getT() {
		List<Integer> list = new ArrayList<Integer>();
		this.printList(list);
		return t;
	}
	public static void main(String[] args) {
		Hello<String> greet = new Hello<>("hi");
		System.out.println(greet.getT());
		Stack<String> stack = new Stack<String>();

		stack.push("Horse");

		stack.push("Cow");

		stack.push("Pig");

		stack.pop();

		System.out.println(stack.pop());
	}

	public void printList(List<?> list) {
		System.out.println(list);
	}
}
	
