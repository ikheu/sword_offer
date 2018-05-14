package sword_offer;
// page 271 二叉树的深度

public class Solution55 {
	public static int treeDepth(BinaryTreeNode root) {
		// 基准情况
		if (root == null) return 0;
		// 左子树深度
		int nleft = treeDepth(root.leftNode);
		// 右子树深度
		int nright = treeDepth(root.rightNode);
		return (nleft > nright) ? nleft + 1 : nright + 1;
	}
	
	// 测试
	public static void main(String[] args) {
		BinaryTreeNode a = new BinaryTreeNode();
		BinaryTreeNode b = new BinaryTreeNode();
		BinaryTreeNode c = new BinaryTreeNode();
		a.rightNode = b;
		b.leftNode = c;
		System.out.println(treeDepth(a));
	}
}