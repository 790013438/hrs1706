import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Test02 {

	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<>();
		list = (List<String>) Proxy.newProxyInstance(
				Test02.class.getClassLoader(), 	// 类加载器
				list.getClass().getInterfaces(), 	// 被代理对象实现的接口
				new ListProxy<>(list));					// 实现了InvocationHandler接口的对象
		list.add("apple");
		list.add("grape");
		list.add("strawberry");
		list.remove("apple");
		list.add(1, "banana");
		list.clear();
	}
}
