package Chapter7;

/**
 * 树中两个节点的最低公共祖先
 * 输入一棵树的根节点，输入两个被观察节点，树的节点中没有指向父节点的指针求这两个节点的最低（最近）公共祖先。
 * 如下图所示的树，输入根节点A和两个节点F,H，输出最低公共祖先B.
 *                      A
                      /   \
                     B     C 
                  /     \
                D        E 
               / \     / | \
              F   G  H   I   J
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CodeInterviews68_LowestCommonAncestor {

	public static class CommonTreeNode {
		public char val;
		public LinkedList<CommonTreeNode> children;

		public CommonTreeNode(char val) {
			this.val = val;
			children = new LinkedList<>();
		}

		public void addChildren(CommonTreeNode... children) {
			for (CommonTreeNode child : children)
				this.children.add(child);
		}
	}

	/**
	 * 不使用辅助空间，从根节点开始判断它的子树是否包含这两个节点，找到最小的的子树；
	 * 时间复杂度最坏O(n^2)，空间复杂度O(1)；
	 * 
	 * @param root  根节点
	 * @param node1 节点1
	 * @param node2 节点2
	 * @return 最低公共祖先
	 */
	public static CommonTreeNode getLowestAncestor1(CommonTreeNode root, CommonTreeNode node1, CommonTreeNode node2) {
		if (root == null || node1 == null || node2 == null || !isInSubTree(root, node1, node2))
			return null;
		CommonTreeNode curNode = root;
		while (true) {
			for (CommonTreeNode child : curNode.children) {
				if (isInSubTree(child, node1, node2)) {
					curNode = child;
					break;
				}
				if (child == curNode.children.get(curNode.children.size() - 1))
					return curNode;
			}
		}
	}

	/**
	 * 判断两个节点是否位于同一颗子树；
	 * 
	 * @param root  根节点
	 * @param node1 节点1
	 * @param node2 节点2
	 * @return 是/否
	 */
	public static boolean isInSubTree(CommonTreeNode root, CommonTreeNode node1, CommonTreeNode node2) {
		Queue<CommonTreeNode> queue = new LinkedList<>();
		CommonTreeNode temp = null;
		int count = 0;
		queue.add(root);
		while (count != 2 && !queue.isEmpty()) {
			temp = queue.poll();
			if (temp == node1 || temp == node2)
				count++;
			if (!temp.children.isEmpty())
				queue.addAll(temp.children);
		}
		if (count == 2)
			return true;
		return false;
	}

	/**
	 * 使用辅助空间，两次DFS遍历获取根节点到两个叶子节点的路径，然后求两个路径的最后一个公共节点；
	 * 时间复杂度O(n)，空间复杂度O(logn)；
	 * 
	 * @param root  根节点
	 * @param node1 叶子节点1
	 * @param node2 叶子节点2
	 * @return 最低公共祖先
	 */
	public static CommonTreeNode getLowestAncestor2(CommonTreeNode root, CommonTreeNode node1, CommonTreeNode node2) {
		ArrayList<CommonTreeNode> path1 = new ArrayList<>();
		ArrayList<CommonTreeNode> path2 = new ArrayList<>();
		getPath(root, node1, path1);
		getPath(root, node2, path2);
		CommonTreeNode lowestAncestor = null;
		for (int i = 0; i < path1.size() && i < path2.size(); i++) {
			if (path1.get(i) == path2.get(i))
				lowestAncestor = path1.get(i);
			else
				break;
		}
		return lowestAncestor;
	}

	/**
	 * 遍历节点获取路径；
	 * 
	 * @param root    根节点
	 * @param node    待判断节点
	 * @param curPath 当前路径
	 * @return 是/否
	 */
	public static boolean getPath(CommonTreeNode root, CommonTreeNode node, ArrayList<CommonTreeNode> curPath) {
		if (root == node)
			return true;
		curPath.add(root);
		for (CommonTreeNode child : root.children) {
			if (getPath(child, node, curPath))
				return true;
		}
		curPath.remove(curPath.size() - 1);
		return false;
	}

	public static void main(String[] args) {
		CommonTreeNode root = new CommonTreeNode('A');
		CommonTreeNode b = new CommonTreeNode('B');
		CommonTreeNode c = new CommonTreeNode('C');
		CommonTreeNode d = new CommonTreeNode('D');
		CommonTreeNode e = new CommonTreeNode('E');
		CommonTreeNode f = new CommonTreeNode('F');
		CommonTreeNode g = new CommonTreeNode('G');
		CommonTreeNode h = new CommonTreeNode('H');
		CommonTreeNode i = new CommonTreeNode('I');
		CommonTreeNode j = new CommonTreeNode('J');
		root.addChildren(b, c);
		b.addChildren(d, e);
		d.addChildren(f, g);
		e.addChildren(h, i, j);
		System.out.println("The Lowest Common Parent of F&H is " + getLowestAncestor1(root, f, h).val
				+ ", by Nonauxiliary Space Method.");
		System.out.println("The Lowest Common Parent of F&H is " + getLowestAncestor2(root, f, h).val
				+ ", by Auxiliary Space Method.");
		System.out.println("The Lowest Common Parent of H&I is " + getLowestAncestor1(root, h, i).val
				+ ", by Nonauxiliary Space Method.");
		System.out.println("The Lowest Common Parent of H&I is " + getLowestAncestor2(root, h, i).val
				+ ", by Auxiliary Space Method.");

	}
}
