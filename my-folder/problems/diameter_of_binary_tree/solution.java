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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] len=new int[1];
        diameter(root,len);
        return len[0];


    }
    public int diameter(TreeNode root,int[] len) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 1;
        int left=diameter(root.left,len);
        int right=diameter(root.right,len);
        len[0]=Math.max(len[0],left+right);
        return 1+Math.max(left,right);


    }
}