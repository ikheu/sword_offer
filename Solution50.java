package sword_offer;
// 第一个只出现一次的字符

public class Solution50 {
	// 将ASCII作为数组下标，存储出现的个数，相当于实现了一个简单的哈希表，也可以直接用map
	public static char firstRepeatchar(String str) {
		int maxNum = 256;
		char target = str.charAt(0);
		int[] arr = new int[maxNum];
		for (int i = 0; i < str.length(); i++)
			arr[(int)(str.charAt(i))]++;
		for (int i = 0; i < str.length(); i++) {
			if (arr[(int)(str.charAt(i))] == 1){
				target = str.charAt(i);
				break;
			}
		}
		return target;
	}
	
	// 相关题目：删除重复的字符
	public static String delRepeatchar(String str) {
		int maxNum = 256;
		StringBuilder strb = new StringBuilder();
		int[] arr = new int[maxNum];
		for (int i = 0; i < str.length(); i++) {
			if (arr[(int)(str.charAt(i))] == 0) {
				arr[(int)(str.charAt(i))]++;
				strb.append(str.charAt(i));
			}
		}
		return strb.toString();
	}
	
	// 相关题目：从第一个字符串中删除在第二个字符串中出现过的所有字符
	public static String delCharInStr2(String str1, String str2) {
		int maxNum = 256;
		StringBuilder strb = new StringBuilder();
		int[] arr = new int[maxNum];
		for (int i = 0; i < str2.length(); i++) {
			if (arr[(int)(str2.charAt(i))] == 0) {
				arr[(int)(str2.charAt(i))]++;
			}
		}
		for (int i = 0; i < str1.length(); i++) {
			if (arr[(int)(str1.charAt(i))] == 0) {  // str1中的字符对应的哈希表在arr中不存在
				strb.append(str1.charAt(i));
			}
		}
		return strb.toString();
	}
	
	// 相关题目：判断是否是变位词
	public static boolean isAnagram(String str1, String str2) {
		int maxNum = 256;
		int[] arr = new int[maxNum];
		if (str1.length() != str2.length()) return false;
		for (int i = 0; i < str1.length(); i++) {
				arr[(int)(str1.charAt(i))]++;
				arr[(int)(str2.charAt(i))]--;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) return false;
		}
		return true;
	}
	
	// 测试
	public static void main(String[] args) {
		System.out.println(firstRepeatchar("abaccdeff"));
		System.out.println(delRepeatchar("abaccdeff"));
		System.out.println(delCharInStr2("We are student.", "aeiou"));
		System.out.println(isAnagram("silent", "listen"));
	}
}
