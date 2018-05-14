package sword_offer;
// page 307 求1+2+...+n 

public class Solution64 {

	public static int sum1(int n) {
		// 利用与运算的性质，实现了递归的终止
		boolean flag = (n > 0) && (n = n + sum1(n - 1)) > 0;
		//  (n == 0) || (n = n + sum1(n - 1)) > 0;
		return n;
	}
	
	// 测试
	public static void main(String[] args) {
		System.out.println(sum1(2));
	}
}