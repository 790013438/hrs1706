import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;


public class ListProxy<E> implements InvocationHandler {
	private List<E> target;
	
	public ListProxy(List<E> target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		Object retValue = method.invoke(target, args);
		String methodName = method.getName();
		if (methodName.startsWith("add") || methodName.startsWith("remove")
				|| methodName.startsWith("clear") || methodName.startsWith("retain")) {
			System.out.println("size = " + target.size());
		}
		return retValue;
	}
	
}