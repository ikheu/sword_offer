package sword_offer;
//page 44 二维数组中的查找

public class Solution04 {
	//从右上角的元素开始查找，逐渐缩小范围
	public static boolean findNum(int[][] arr, int target) {
		boolean found = false;
		int row = 0;
		int col = arr[0].length - 1;
		while (col >= 0 && row <= arr.length - 1) {
			int diff = arr[row][col] - target;
			if (diff == 0) {
				found = true;
				break;
			}
			else if (diff > 0) 
				col--;
			else 
				row++;
		}
		return found;
	}
	
	//测试函数
	public static void main(String[] args) {
		int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(findNum(arr, 4));
	}
}