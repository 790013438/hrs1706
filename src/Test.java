import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AddHelloThread implements Runnable {
	private List<String> list;
	
	public AddHelloThread(List<String> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10000; ++i) {
			list.add("hello");
		}
	}
}

public class Test {

	private static ExecutorService pool = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) {
		// List<String> list = new CopyOnWriteArrayList<>();
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		for (int i = 1; i <= 5; ++i) {
			// new Thread(new AddHelloThread(list)).start();
			pool.execute(new AddHelloThread(list));
		}
		pool.shutdown();
		while (!pool.isTerminated()) ;
		System.out.println(list.size());
//		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//			System.out.println(list.size());
//		}));
	}
}
