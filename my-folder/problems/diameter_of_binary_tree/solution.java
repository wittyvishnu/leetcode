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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        if(root.left==null && root.right==null)return 0;
        return max-1;
    }
    public int maxDepth(TreeNode root){
        if(root==null)return 0;
        else if(root.left==null && root.right==null)return 1;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        max=Math.max(max,left+right+1);
        return Math.max(left,right)+1;
    }
}