package sword_offer;
//page 58 从尾到头打印链表
import java.util.Stack;

//链表类
class ListNode{
	ListNode next = null;
	int value;
	public void printOut() {
		System.out.println(value);
		ListNode tmp = next;
		while (tmp != null) {
			System.out.println(tmp.value);
			tmp = tmp.next;
		}
	}
}

public class Solution06 {
		
	//方法1：使用Stack栈的先push后pop
	public static void printListReverse(ListNode listNode) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while(listNode != null) {
			stack.push(listNode);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().value);
		}
	}
	
	//方法2：使用递归的方式，相当于从内部往外部推
	public static void printListReverse_rec(ListNode listNode) {
		if(listNode != null) {
			if (listNode.next != null)
				printListReverse_rec(listNode.next);
			System.out.println(listNode.value);
		}
	}
	
	//测试
	public static void main(String[] args) {
		ListNode ln1 = new ListNode();
		ListNode ln2 = new ListNode();
		ListNode ln3 = new ListNode();
		ln1.next = ln2;
		ln2.next = ln3;
		ln1.value = 1;
		ln2.value = 2;
		ln3.value = 3;
		printListReverse_rec(ln1);
		printListReverse(ln1);		
	}
}

