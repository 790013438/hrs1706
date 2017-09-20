import java.util.ArrayList;
import java.util.List;

class A {
	private static A instance = null;
	private static Object mutex = new Object();

	private A() {
	}

	public static A getInstance() {
		synchronized (mutex) {
			if (instance == null) {
				instance = new A();
			}
		}
		return instance;
	}
}

class Test01 {

	public static void main(String[] args) {
		// main(null);
		// StackOverflowError
		List<Object> list = new ArrayList<>();
		while (true) {
			list.add(new Object());
		}
		// OutOfMemoryError
	}
}
