package sword_offer;
//page 62 重建二叉树

//二叉树类，包含左右子树，以及用于查看的方法
class BinaryTreeNode {
	int value;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
	//中序遍历输出查看
	public void printList() {
		if (leftNode != null)
			leftNode.printList();
		System.out.println(value);
		if (rightNode != null)
			rightNode.printList();
	}
}

public class Solution07 {
	//重建二叉树函数
	public static BinaryTreeNode rebultTree(int[] preorder, int[] inorder) {
		BinaryTreeNode root = rebultTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		return root;
	}
	//重写函数
	private static BinaryTreeNode rebultTree(int[] preorder, int startPre, int endPre, int[] inorder, int startIn,
			int endIn) {
		if (startPre > endPre || startIn > endIn)
			return null;
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = preorder[startPre];
		for (int i = startIn; i <= endIn; i++) {
			if (inorder[i] == preorder[startPre]) {
				root.leftNode = rebultTree(preorder, startPre + 1, startPre + i - startIn, inorder, startIn, i - 1);
				root.rightNode = rebultTree(preorder, startPre + i - startIn + 1, endPre, inorder, i + 1, endIn);
			}
		}
		return root;
	}
	//测试
	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode root = rebultTree(preorder, inorder);
		//System.out.println(root.leftNode.rightNode.value);
		root.printList();
	}
}