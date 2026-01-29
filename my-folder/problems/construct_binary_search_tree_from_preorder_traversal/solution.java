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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=construct(preorder,0,preorder.length-1);
        return root;
    }
    public TreeNode construct(int[] preorder,int start,int end){
    if(start>end)return null;
    TreeNode root=new TreeNode(preorder[start]);
    int index=end+1;
    for(int i=start+1;i<=end;i++)
    if(preorder[i]>root.val){
        index=i;
        break;
    }
    root.left=construct(preorder,start+1,index-1);
    root.right=construct(preorder,index,end);
    return root;
    }
}