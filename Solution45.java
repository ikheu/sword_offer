package sword_offer;
// page 227 把数组排成最小的数

public class Solution45 {
	public static void printMin(int[] arr) {
		printMinNumber(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i);
		System.out.println();
	}

	// 注意快排的不同形式
	public static void printMinNumber(int[] arr, int left, int right) {
		if (left < right) {
			int main_number = arr[right];
			int small_cur = left;
			for (int j = left; j < right; j++) {
				if (isSmall(String.valueOf(arr[j]), String.valueOf(main_number))) { // 小于时交换
					int temp = arr[j];
					arr[j] = arr[small_cur];
					arr[small_cur] = temp;
					small_cur++;
				}
			}
			arr[right] = arr[small_cur];
			arr[small_cur] = main_number;
			printMinNumber(arr, 0, small_cur - 1);
			printMinNumber(arr, small_cur + 1, right);
		}
	}

	// 判断字符串是否满足mn < nm
	public static boolean isSmall(String m, String n) {
		String left = m + n;
		String right = n + m;
		return left.compareTo(right) < 0; // 也可以重写函数
	}

	// 测试
	public static void main(String[] args) {
		int arr[] = { 3, 1, 2, 11 };
		printMin(arr);
	}
}