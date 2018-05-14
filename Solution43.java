package sword_offer;
// page 221 1~n整数中出现1的个数

public class Solution43 {
	// 计算整数n中含有1的个数
	private static int countOne(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 10 == 1)
				count++;
			n = n / 10;
		}
		return count;
	}

	// 计算整数1~n中含有1的个数
	public static int countTotalOne(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += countOne(i);
		}
		return count;
	}

	// 测试
	public static void main(String[] args) {
		System.out.println(countTotalOne(100));
	}
}