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
   TreeNode dummy=new TreeNode(-1); 
    public void flatten(TreeNode root) {
        construct(root);
    }
    public void construct(TreeNode root){
        if(root==null)return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        dummy.right=root;
        dummy=dummy.right;
        construct(left);
        construct(right);


    }
}