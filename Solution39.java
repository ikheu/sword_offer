package sword_offer;
//page 205 数组中出现次数超过一半的数字

public class Solution39 {
	// 方法1：利用数组中位数的特性以及快速排序的思想
	public static int moreThanHalfNum_s1(int[] arr) {
		int mid = arr.length >> 1;
		int start = 0;
		int end = arr.length - 1;
		int index = partition(arr, start, end);
		while (index != mid) {
			if (index > mid) {
				end = index - 1;
				index = partition(arr, start, end);
			} else {
				start = index + 1;
				index = partition(arr, start, end);
			}
		}
		int result = arr[mid];
		return result;
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

	// 方法2：基于数组特点
	public static int moreThanHalfNum_s2(int[] arr) {
		int result = arr[0];
		int times = 1;
		for (int i = 1; i < arr.length; i++) {
			if (times == 0) {
				result = arr[i];
				times = 1;
			} else if (arr[i] == result)
				times++;
			else
				times--;
		}
		return result;
	}

	// 测试
	public static void main(String[] args) {
		int[] arr = { 3, 3, 1, 1, 1, 4, 4, 1 };
		System.out.println(moreThanHalfNum_s1(arr));
		System.out.println(moreThanHalfNum_s2(arr));
	}
}
