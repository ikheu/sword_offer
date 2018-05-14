package sword_offer;
// page 218 连续子数组的最大和

public class Solution42 {
	public static int maxSub(int[] arr) {
		int maxSum = 0, tempSum = 0;
		for (int i = 0; i < arr.length; i++) {
			tempSum += arr[i];
			if (tempSum > maxSum)
				maxSum = tempSum;
			else if (tempSum < 0)
				tempSum = 0;
		}
		return maxSum;
	}

	// 测试
	public static void main(String[] args) {
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(maxSub(arr));
	}
}