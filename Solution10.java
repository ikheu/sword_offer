package sword_offer;
//page 74 斐波那契数列

public class Solution10 {
	//获得fibonacci(n)
	public static long fibonacci(int n) {
		if (n <= 1) return n;
		long fibMinusOne = 0;
		long fibMinusTwo = 1;
		long fib = 0;
		for (int i = 2; i <= n; i++) {
			fib = fibMinusOne + fibMinusTwo;
			fibMinusOne = fibMinusTwo;
			fibMinusTwo = fib;
		}
		return fib;
	}
	//测试函数
	public static void main(String[] args) {
		System.out.println(fibonacci(6));
	}
}