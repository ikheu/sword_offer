package sword_offer;
// page 119 删除链表中的节点 

public class Solution18 {
	public static void deleteNode(ListNode root, ListNode toBeDeleted) {
		// 要删的节点是根节点(这种情况下的操作是无效的，没真正删除)
		if (root.equals(toBeDeleted)) {
			root = root.next;
			return;
		}
		ListNode tmp = toBeDeleted.next;
		// 是否是最后一个节点？不是则通过赋值完成删除，是则通过从前向后遍历，完成删除
		if (tmp != null) {
			toBeDeleted.value = tmp.value;
			if (tmp.next != null)
				toBeDeleted.next = tmp.next;
			tmp.next = null;
		} else {
			tmp = root;
			while (!tmp.next.equals(toBeDeleted)) {
				tmp = tmp.next;
			}
			tmp.next = null;
		}
	}

	// 测试
	public static void main(String[] args) {
		ListNode[] ln = new ListNode[6]; // 1 -> 2 -> 3 -> 4 -> 5 -> 6
		for (int i = 0; i < ln.length; i++) {
			ln[i] = new ListNode();
			ln[i].value = i;
			if (i > 0)
				ln[i - 1].next = ln[i];
		}
		ln[0].printOut();
		deleteNode(ln[0], ln[2]);
		System.out.println("==== after delete ====");
		ln[0].printOut();
	}
}