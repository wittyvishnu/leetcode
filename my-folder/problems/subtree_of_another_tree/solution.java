/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null)return true;
        if(root==null)return false;
        if(root.val==subRoot.val&&identical(root,subRoot))
        return true;
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);

    }
    public boolean identical(TreeNode root,TreeNode subRoot){
        if(root==null||subRoot==null)
        return (root==null)&&(subRoot==null);
        if(root.val!=subRoot.val)
        return false;
        return identical(root.left,subRoot.left)&&identical(root.right,subRoot.right);

    }
}