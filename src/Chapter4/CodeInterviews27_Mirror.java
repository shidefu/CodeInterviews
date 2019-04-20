package Chapter4;

/** 
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：
         原二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9  11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;
 
    }
 
}

public class CodeInterviews27_Mirror {
	
	public void Mirror(TreeNode root) {
        TreeNode tmp = null;
        if(root != null){
            tmp = root.right;
            root.right = root.left;
            root.left = tmp;
            Mirror(root.left);
            Mirror(root.right);
       }
    }

}
