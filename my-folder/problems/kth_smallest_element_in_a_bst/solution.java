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
    int ans;
    int size=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }
    public void dfs(TreeNode root,int k){
       if(root==null || size==k)return;
       dfs(root.left,k);
       if(size==k)return;
       ans=root.val;
       size++;

       dfs(root.right,k);
    }
    
}