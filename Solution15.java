package sword_offer;
//page 100 二进制中1的个数

public class Solution15 {
	// 方法1：逐位进行与运算
	public static int numOfOne_a(int n) {
		int flag = 1;
		int count = 0;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag = flag << 1;
		}
		return count;
	}

	// 方法二：进行n = (n - 1) & n运算，n含有1的位数减1
	public static int numOfOne_b(int n) {
		int count = 0;
		while (n != 0) {
			n = (n - 1) & n;
			count++;
		}
		return count;
	}

	// 测试
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(-10000));
		System.out.println(numOfOne_a(10000));
		System.out.println(numOfOne_b(-10000));
	}
}