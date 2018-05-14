package sword_offer;
// page 159 对称的二叉树

public class Solution28 {
	public static boolean isSymmetrical(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}

	private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.value != root2.value)
			return false;
		return isSymmetrical(root1.leftNode, root2.rightNode) && isSymmetrical(root1.rightNode, root2.leftNode);
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
		c.value = 6;
		d.value = 5;
		e.value = 7;
		f.value = 7;
		g.value = 5;
		System.out.println(isSymmetrical(a));
	}
}
