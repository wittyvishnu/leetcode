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
class pair{
    TreeNode node;
    int v;
    pair(TreeNode n,int ve){
        node=n;
        v=ve;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int maxWidth=1;
        Deque<pair> dq=new ArrayDeque<>();
        dq.offer(new pair(root,1));
        while(!dq.isEmpty()){
            maxWidth=Math.max(maxWidth,dq.peekLast().v-dq.peekFirst().v+1);
            int size=dq.size();
            for(int i=1;i<=size;i++){
                pair temp=dq.poll();
                TreeNode node=temp.node;
                if(node.left!=null)dq.offer(new pair(node.left,2*temp.v));
                if(node.right!=null)dq.offer(new pair(node.right,2*temp.v+1));
            }
        }
        return maxWidth;
        
        
    }
}