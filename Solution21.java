package sword_offer;
// page 21 调整数组顺序使奇数位于偶数前面
import java.util.Arrays;

public class Solution21 {
	// 按一定规则调整数组的程序
	public static void reorderOddEven(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			while (start < end && isOdd(arr[start]))
				start++;
			while (start < end && !isOdd(arr[end]))
				end--;
			if (start < end) {
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
			}
		}
	}

	// 单独定义一个函数，提高扩展性
	private static boolean isOdd(int x) {
		return (x & 1) == 1;
	}

	// 测试
	public static void main(String[] args) {
		int[] arr = { 0, 1, 3, 5, 4, 9 };
		reorderOddEven(arr);
		System.out.println(Arrays.toString(arr));
	}
}
