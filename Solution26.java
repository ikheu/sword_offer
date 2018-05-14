package sword_offer;
// page 157 二叉树的镜像

public class Solution26 {
	public static void mirrorTree(BinaryTreeNode root) {
		if (root == null || (root.leftNode == null && root.rightNode == null))
			return;
		BinaryTreeNode tmp = root.leftNode;
		root.leftNode = root.rightNode;
		root.rightNode = tmp;
		if (root.leftNode != null)
			mirrorTree(root.leftNode);
		if (root.rightNode != null)
			mirrorTree(root.rightNode);
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
		a.printList();
		mirrorTree(a);
		System.out.println("=========="); // 中序输出也是对称的
		a.printList();
	}
}
