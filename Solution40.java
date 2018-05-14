package sword_offer;
// page 209 最小的k个数
import java.util.Arrays;

public class Solution40 {

	public static void getLeastNums(int[] arr, int k) {
		int start = 0;
		int end = arr.length - 1;
		int index = partition(arr, start, end);
		while (index != k - 1) { // 注意索引与个数的关系，注意差1错误
			if (index < k - 1) {
				start = index + 1;
				index = partition(arr, start, end);
			} else {
				end = index - 1;
				index = partition(arr, start, end);
			}
		}
	}

	// 快排确定一个索引
	public static int partition(int[] arr, int start, int end) {
		int mid = end;
		end = end - 1;
		while (start < end) {
			while (start < end && arr[start] < arr[mid])
				start++;
			while (start < end && arr[end] >= arr[mid])
				end--;
			swap(arr, start, end);
		}
		if (arr[start] >= arr[mid]) {
			swap(arr, start, mid);
		} else
			start++;
		return start;
	}

	// 交换
	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	// 测试
	public static void main(String[] args) {
		int[] arr = { 3, 3, 1, 1, 1, 4, 4, 1 };
		getLeastNums(arr, 1);
		System.out.println(Arrays.toString(arr));
	}
}