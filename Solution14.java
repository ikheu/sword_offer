package sword_offer;
// page 96 剪绳子
import java.lang.Math;

public class Solution14 {
	// 动态规划算法，比较容易想到
	public static int maxProduct_s1(int len) {
		if (len < 2) return 0;
		if (len == 2) return 1;
		if (len == 3) return 2;
		int[] products = new int[len + 1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		int max = 0;
		for (int i = 4; i <= len; i++) {
			for (int j = 1; j <= i / 2; j++) {
				int product = products[j] * products[i - j];
				if (max < product)
					max = product;
				products[i] = max;
			}
		}
		max = products[len];
		return max;
	}

	// 贪婪算法，很不容易想到
	public static int maxProduct_s2(int len) {
		if (len < 2) return 0;
		if (len == 2) return 1;
		if (len == 3) return 2;
		int times3 = len / 3;
		if (len - times3 * 3 == 1)
			times3--;
		int times2 = (len - times3 * 3) / 2;
		return (int) (Math.pow(3, times3)) * (int) (Math.pow(2, times2));

	}

	// 测试
	public static void main(String[] args) {
		System.out.println(maxProduct_s1(20));
		System.out.println(maxProduct_s2(20));
	}

}
