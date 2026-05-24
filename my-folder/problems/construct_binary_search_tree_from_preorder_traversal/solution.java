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
        if (preorder.length==0) return null;
        return construct(preorder,0,preorder.length-1);
    }
    public TreeNode construct(int[] preorder,int start,int end){
        if(start>end)return null;
        TreeNode root=new TreeNode(preorder[start]);
        int numsLeft=end-start;
        for(int i=start+1;i<=end;i++){
            if(preorder[i]>preorder[start]){
                numsLeft=i-start-1;
                break;
            }
        }
        root.left=construct(preorder,start+1,start+numsLeft);
        root.right=construct(preorder,start+numsLeft+1,end);
        return root;
        
    }
}