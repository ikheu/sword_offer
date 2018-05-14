package sword_offer;
// page 171 从上到下打印二叉树
import java.util.LinkedList;
import java.util.Queue;

public class Solution32 {
	public static void printTreeTopToBottom(BinaryTreeNode root) {
		if (root == null)
			return;
		// 创建个队列queue
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			// 弹出后打印，再插入该节点的左节点、右节点
			BinaryTreeNode node = queue.poll();
			System.out.println(node.value);
			if (node.leftNode != null)
				queue.add(node.leftNode);
			if (node.rightNode != null)
				queue.add(node.rightNode);
		}
	}

	// 测试
	public static void main(String[] args) {
		BinaryTreeNode a = new BinaryTreeNode();
		BinaryTreeNode b = new BinaryTreeNode();
		BinaryTreeNode c = new BinaryTreeNode();
		BinaryTreeNode d = new BinaryTreeNode();
		BinaryTreeNode e = new BinaryTreeNode();
		BinaryTreeNode f = new BinaryTreeNode();
		BinaryTreeNode g = new BinaryTreeNode();
		a.leftNode = b;
		a.rightNode = c;
		b.leftNode = d;
		b.rightNode = e;
		c.leftNode = f;
		c.rightNode = g;
		a.value = 8;
		b.value = 6;
		c.value = 10;
		d.value = 5;
		e.value = 7;
		f.value = 9;
		g.value = 11;
		printTreeTopToBottom(a);
	}
}
