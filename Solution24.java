package sword_offer;
// page 142 反转链表

public class Solution24 {
	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	// 测试
	public static void main(String[] args) {
		ListNode[] ln = new ListNode[6]; // 1 -> 2 -> 3 -> 4 -> 5 -> 6
		for (int i = 0; i < ln.length; i++) {
			ln[i] = new ListNode();
			ln[i].value = i + 1;
			if (i > 0)
				ln[i - 1].next = ln[i];
		}
		ln[0].printOut();
		reverseList(ln[0]);
		System.out.println("=========反转前后========");
		ln[5].printOut();
	}
}