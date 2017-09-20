import java.util.ArrayList;
import java.util.List;

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
