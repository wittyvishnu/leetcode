/**
 * Definition for a binary tree root.
 * public class TreeNode {
 *     long val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(long val) { this.val = val; }
 *     TreeNode(long val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
    public boolean isValidBST(TreeNode root) {
        
    return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
    private boolean isValid(TreeNode root,long min,long max){
        if(root==null)return true;
        if(!(root.val>min && root.val<max))return false;
        return  isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);

    }
}