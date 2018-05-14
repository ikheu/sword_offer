package sword_offer;
//page 51 替换空格

public class Solution05 {
	//在Java中字符串时不可变的，因而只能构造一个新的字符串。原文中该题的难点也无法体现出来了。
	public static String replaceBlank(String str) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				strb.append("%20");
			}
			else 
				strb.append(str.charAt(i));
		}
		return strb.toString();
	}
	
	//测试
	public static void main(String[] args) {
		String str = "We are happr.";
		System.out.println(replaceBlank(str));
	}
}
