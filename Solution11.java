package sword_offer;
//page 82 旋转数组的最小数字

public class Solution11 {

	public static int min(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		if (arr[start] < arr[end]) //旋转数组是其本身的情形
			return arr[start];
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr[mid] == arr[start] && arr[mid] == arr[end]) //考虑顺序查找情形
				return min(arr, start, end);
			if (arr[mid] >= arr[start])
				start = mid;
			else
				end = mid;
			if (start == end - 1)
				break;
		}
		return arr[end];
	}
	//特殊情形下的顺序查找
	private static int min(int[] arr, int start, int end) {
		int result = arr[start];
		for (int i = start + 1; i <= end; i++)
			if (arr[i] < result)
				result = arr[i];
		return result;

	}
	//测试
	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 2, 3 };
		int[] arr2 = { 1, 0 , 1, 1, 1 };
		System.out.println(min(arr));
		System.out.println(min(arr2));
	}
}
