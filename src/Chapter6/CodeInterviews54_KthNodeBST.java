package Chapter6;

/**
 * 二叉搜索树的第k大结点
 * 给定一棵二叉搜索树，请找出其中的第k大的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第3大结点的值为6。
 */

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;
 
    } 
}

public class CodeInterviews54_KthNodeBST {
	
	TreeNode KthNode(TreeNode pRoot, int k){
        ArrayList<TreeNode> list = inOrder(pRoot);
        if(k > 0 && k <= list.size()){  
            return list.get(list.size()-k);
        }
        return null;
    }
     
    ArrayList<TreeNode> inOrder(TreeNode pRoot){
        ArrayList<TreeNode> list = new ArrayList<>();
        if(pRoot == null) {
            return list;
        }
        list.addAll(inOrder(pRoot.left));
        list.add(pRoot);
        list.addAll(inOrder(pRoot.right));
        return list;
    }

}
