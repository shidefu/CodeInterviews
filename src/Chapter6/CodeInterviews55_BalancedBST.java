package Chapter6;

/**
 * 二叉树的深度与平衡二叉树
 * 1.输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 2.输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public class CodeInterviews55_BalancedBST {

	public class Solution {
		public boolean IsBalanced_Solution(TreeNode root) {
			return getDepth(root) != -1;
		}

		// 剪枝：从叶子节点开始遍历，每个节点只遍历一次，如果不平衡直接丢弃；
		private int getDepth(TreeNode root) {
			if (root == null)
				return 0;
			int left = getDepth(root.left);
			if (left == -1)
				return -1;
			int right = getDepth(root.right);
			if (right == -1)
				return -1;
			return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
		}
	}

}
