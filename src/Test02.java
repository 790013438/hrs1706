import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Test02 {

	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<>();
		list = (List<String>) Proxy.newProxyInstance(
				Test02.class.getClassLoader(), 	// �������
				list.getClass().getInterfaces(), 	// ���������ʵ�ֵĽӿ�
				new ListProxy<>(list));					// ʵ����InvocationHandler�ӿڵĶ���
		list.add("apple");
		list.add("grape");
		list.add("strawberry");
		list.remove("apple");
		list.add(1, "banana");
		list.clear();
	}
}
