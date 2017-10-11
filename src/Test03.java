import java.util.Comparator;

public class Test03 {
	
	public static double factorial(int n) {
		if (n == 1 || n == 0) return 1;
		return n * factorial(n - 1);
	}
	
	public static String reverse(String str) {
		if (str == null || str.length() == 1) return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("Hello, world!"));
	}
	
	public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
		assert array != null && key != null && comp != null;
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) >>> 1;
			if (comp.compare(key, array[mid]) > 0) {
				start = mid + 1;
			} else if (comp.compare(key, array[mid]) < 0) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] array, T key) {
		assert array != null && key != null;
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) >>> 1;
			if (key.compareTo(array[mid]) > 0) {
				start = mid + 1;
			} else if (key.compareTo(array[mid]) < 0) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
