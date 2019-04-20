package Chapter4;

/** 
 * 1.把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * 2.按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}
*/

public class CodeInterviews32_PrintTree {
	// 分层打印二叉树；
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> layerList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (pRoot == null) {
			return list;
		}
		int num = 0;
		int total = 1;
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			layerList.add(p.val);
			num++;
			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
				queue.offer(p.right);
			// 判断本层打印是否完成
			if (num == total) {
				// 此时的queue中存储的都是下一层的节点，则end即为queue大小
				total = queue.size();
				num = 0;
				list.add(layerList);
				/**
				 * 重置arrayList,注意必须new一个，不能使用layerList.clear()，后者会将layerList清空，
				 * ArrayList是引用类型，清空后所有的layerList都将指向一个空表。
				 */
				layerList = new ArrayList<>();
			}
		}
		return list;
	}

	// 按之子形顺序打印二叉树；在队列实现二叉树层次遍历的基础上修改的，增加了一个栈，借助栈来帮助偶数层结点逆序；
	public ArrayList<ArrayList<Integer>> PrintZhi(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> layerList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (pRoot == null) {
			return list;
		}
		int level = 1;
		int num = 0;
		int total = 1;
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			num++;
			if (level % 2 == 0) {
				stack.push(p);
				if (num == total) {
					while (!stack.empty()) {
						layerList.add(stack.pop().val);
					}
				}
			} else {
				layerList.add(p.val);
			}
			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
				queue.offer(p.right);
			if (num == total) {
				total = queue.size();
				num = 0;
				level++;
				list.add(layerList);
				layerList = new ArrayList<>();
			}
		}
		return list;
	}

	// 把数组转换为二叉树
	private TreeNode createBinaryTreeByArray(int[] array, int index) {
		TreeNode root = null;
		if (index < array.length) {
			int value = array[index];
			root = new TreeNode(value);
			root.left = createBinaryTreeByArray(array, 2 * index + 1);
			root.right = createBinaryTreeByArray(array, 2 * index + 2);
			return root;
		}
		return root;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		TreeNode treeNode = new CodeInterviews32_PrintTree().createBinaryTreeByArray(array, 0);
		for (ArrayList<Integer> arraylist : new CodeInterviews32_PrintTree().Print(treeNode)) {
			System.out.println(arraylist);
		}
		for (ArrayList<Integer> arraylist : new CodeInterviews32_PrintTree().PrintZhi(treeNode)) {
			System.out.println(arraylist);
		}
	}

}
