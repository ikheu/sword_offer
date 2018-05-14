package sword_offer;
// page 16 数值的整数次方

public class Solution16 {
	// 幂运算函数，f=x^n，不用考虑大数问题，n可能为负整数
	public static double myPow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (n < 0)
			return 1.0 / (x * myPow(x, -n - 1));// 避免溢出
		double result = myPow(x, n >> 1);// 位运算除2
		result *= result;
		if ((n & 1) == 1)// 位运算判断奇偶
			result *= x;
		return result;
	}
	// 测试
	public static void main(String[] args) {
		int a = -2147483648;
		System.out.println(myPow(1.0, a));
		System.out.println(myPow(2.0, 4));
		System.out.println(myPow(2.0, 3));
		
	}
}