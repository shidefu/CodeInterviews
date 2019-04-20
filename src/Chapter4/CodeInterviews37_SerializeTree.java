package Chapter4;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树.
 */

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

/**
 * 根据前序遍历规则完成序列化与反序列化。
 * 所谓序列化指的是遍历二叉树为字符串；
 * 所谓反序列化指的是依据字符串重新构造成二叉树。
 * 另外，结点之间的数值用逗号隔开。
 */

public class CodeInterviews37_SerializeTree {

	public int i = -1;

	public String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	public TreeNode Deserialize(String str) {
		i++;
		String[] arr = str.split(",");
		if (i >= arr.length) {
			return null;
		}
		TreeNode root = null;
		if (!arr[i].equals("#")) {
			root = new TreeNode(Integer.parseInt(arr[i]));
			root.left = Deserialize(str);
			root.right = Deserialize(str);
		}
		return root;
	}

}
