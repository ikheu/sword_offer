package sword_offer;
// page 134 链表中倒数第k个节点

/*class ListNode{           Solution6定义过了
	ListNode next = null;
	int value;
}*/
public class Solution22 {
	public static ListNode findKthTail(ListNode head, int k) {
		ListNode res = head;
		int i = 1;
		while (head.next != null) {
			i++;
			head = head.next;
			if (i > k)
				res = res.next;
		}
		if (i < k || k < 1)
			throw new IllegalArgumentException("Not exist");
		return res;
	}

	public static void main(String[] args) {
		ListNode[] ln = new ListNode[6]; // 1 -> 2 -> 3 -> 4 -> 5 -> 6
		for (int i = 0; i < ln.length; i++) {
			ln[i] = new ListNode();
			ln[i].value = i + 1;
			if (i > 0)
				ln[i - 1].next = ln[i];
		}
		System.out.println(findKthTail(ln[0], 1).value);
	}
}