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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        inverse(root);
        return root;
    }
    public void inverse(TreeNode p){
        if(p==null)return;
        TreeNode temp=p.left;
        p.left=p.right;
        p.right=temp;
        inverse(p.left);
        inverse(p.right);

    }
}