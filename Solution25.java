package sword_offer;
// page 合并两个排序的链表

public class Solution25 {
	public static ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode mergeHead = null;
		if (head1.value < head2.value) {
			mergeHead = head1;
			mergeHead.next = merge(head1.next, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = merge(head1, head2.next);
		}
		return mergeHead;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 10 };

		// 定义链表1
		ListNode[] ln1 = new ListNode[arr1.length];
		for (int i = 0; i < ln1.length; i++) {
			ln1[i] = new ListNode();
			ln1[i].value = arr1[i];
			if (i > 0)
				ln1[i - 1].next = ln1[i];
		}

		// 定义链表2
		ListNode[] ln2 = new ListNode[arr2.length];
		for (int i = 0; i < ln1.length; i++) {
			ln2[i] = new ListNode();
			ln2[i].value = arr2[i];
			if (i > 0)
				ln2[i - 1].next = ln2[i];
		}
		merge(ln1[0], ln2[0]).printOut();
	}
}