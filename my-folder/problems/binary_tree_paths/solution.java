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
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)return null;
        traverse(root,new StringBuilder());
        return ans;

    }
    public void traverse(TreeNode root,StringBuilder sb){
        if(root==null)return;
        int len=sb.length();
        if(len>0)
        sb.append("->");
        sb.append(root.val);
        if(isLeaf(root))
            ans.add(sb.toString());
        else{
        traverse(root.left,sb);
        traverse(root.right,sb);
        }
        sb.setLength(len);
        
        
    }
    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null)return true;
        return false;
    }
}