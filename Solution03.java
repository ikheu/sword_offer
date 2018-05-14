package sword_offer;
//page 39 数组中重复的数字

import java.util.Arrays;
public class Solution03 {
	//题目1
	//输出数组中重复的数字，空间复杂度O(1)，时间复杂度O(n)
	//数组长度为n，数字在0~n-1范围内
	public static int duplicate(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			//System.out.println(i);
			while (arr[i] != i) {
				if (arr[i] == arr[arr[i]])
					return arr[i];
				else {
					int temp = arr[i];
					arr[i] = arr[temp];
					arr[temp] = temp;
					System.out.println(Arrays.toString(arr));
				}
			}
		}
		return -1;
	}
	
	//题目2
	//输出数组中重复的数字，空间复杂度O(1)，时间复杂度O(nlog(n))
	//数组长度为n+1，数字在1~n范围内，要求不修改数组，并不使用辅助空间
	public static int myGetDuplication(int[] arr) {
		int start = 1;
		int middle = arr.length / 2;
		int end = middle;
		while(end >= start) {
			//System.out.println("" + start + end);
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= start && arr[i] <= end) count++;
			}
			if (end == start) {
				if (count > 1)
					return start;
				else
					break;
			}
			if (count > end - start + 1) {
				middle = (start + end) / 2;
				end = middle;
			}
			else {
				start = middle + 1;
				end = arr.length - 1;
			}
		}
		return -1;
	}
	//输出数组中重复的数字，空间复杂度O(1)，时间复杂度O(nlog(n))
	//数组长度为n+1，数字在1~n范围内，要求不修改数组，并不使用辅助空间
	//比上一个函数逻辑清晰一点
	public static int getDuplication(int[] arr) {
		int start = 1;
		int end = arr.length - 1;
		while(end >= start) {
			int middle = (end - start) / 2 + start;//这句是二分法的关键，以后用到二分法，则应该想到这种格式。
			int count = getCount(arr, start, middle);
			if (end == start) {
				if (count > 1)
					return start;
				else
					break;//采用二分法，end==start是必然发生的，这里加上break避免死循环
			}
			if (count > middle - start + 1) {
				end = middle;
			}
			else
				start = middle + 1;
		}
		return -1;//程序必须要返回一个int，上述程序有判断，所以加上这句。若执行，则表示程序输入有问题。
	}
	
	//计算数组arr元素处在[start, end]范围内元素个数
	private static int getCount(int[] arr, int start, int end) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= start && arr[i] <= end) count++;
		}
		return count;
	}
	
	//测试
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4,5,6,0};
		System.out.println(duplicate(arr));
		int[] arr2 = {2, 3, 5, 4, 3, 2, 6, 7};
		System.out.println(myGetDuplication(arr2));
		int[] arr3 = {2, 3, 5, 4, 3, 2, 6, 7};
		System.out.println(getDuplication(arr3));
	}
}