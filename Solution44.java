package sword_offer;
// page 225 数组序列中的某一位数字
import java.lang.Math;
public class Solution44 {
	// 这里没采用原文中将程序拆分为几个小程序的形式，考虑到个位数的特殊性，直接在前面处理
	public static int digitAtIndex(int index) {
		if (index < 10) return index;
		int n = 2;    //位数
		index = index - 10;//初始化位位数为1的个数
		while(true) {
			int numsOfN = 9 * (int) Math.pow(10, n - 1);               //n位的个数
			if (index < numsOfN * n) {                                 //是否在这个区间
				int number = (int) Math.pow(10, n - 1) + index / n;    //对应的整数
				int indexFromRight = n - index % n;                    //从右边数第几位
				for (int i = 1; i < indexFromRight; i++) {             //找到那一位
					number /= 10;
				}
				return number % 10;
			}
			index -= numsOfN * n;
			n++;
		}
	}
	
	// 测试
	public static void main(String[] args) {
		System.out.println(digitAtIndex(1001));
	}
}