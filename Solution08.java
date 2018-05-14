package sword_offer;
//page 65 二叉树的下一个节点

//定义二叉树类，包含左右子树、父节点，以及用于查看的函数
class TreeNode {
	char value;
	TreeNode left;
	TreeNode right;
	TreeNode father;
	
	//中序遍历输出查看
	public void printList() {
		if (left != null)
			left.printList();
		System.out.println(value);
		if (right != null)
			right.printList();
	}
}

public class Solution08 {
	public static TreeNode findNext(TreeNode node) {
		//有右节点，找到右子树的最左节点
		if (node.right!= null) {
			node = node.right;
			while(node.left != null) node = node.left;
			return node;
		}
		
		//无右节点，则向上遍历，直至找到节点为父节点的左子节点
		while(node.father != null) {
			if (node.father.left == node) return node.father;
			node = node.father;
		}
		return null;
	}
	public static void main(String[] args) {
		//建立一个二叉树节点的数组，并tree[i].value赋值
		TreeNode[] tree = new TreeNode[9];
		char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new TreeNode();
			tree[i].value = chars[i];
		}
		/*
		 *        a
		 *      /   \
		 *     b     c
		 *    / \   / \
		 *   d   e  f  g
		 *      / \
		 *     h   i
		 */
		//左右节点关系
		tree[0].left = tree[1];
		tree[0].right = tree[2];
		tree[1].left = tree[3];
		tree[1].right = tree[4];
		tree[2].left = tree[5];
		tree[2].right = tree[6];
		tree[4].left = tree[7];
		tree[4].right = tree[8];
		//父节点关系
		tree[1].father = tree[0];
		tree[2].father = tree[0];
		tree[3].father = tree[1];
		tree[4].father = tree[1];
		tree[5].father = tree[2];
		tree[6].father = tree[2];
		tree[7].father = tree[4];
		tree[8].father = tree[4];
		
		tree[0].printList();
	}

}
