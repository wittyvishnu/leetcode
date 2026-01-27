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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        if(root==null)return ans;
        q.offer(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> sublist=new ArrayList<>();
             for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight) 
                sublist.add(node.val);
                else 
                sublist.add(0, node.val); 
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            leftToRight=!leftToRight;

            ans.add(sublist);
        }
        return ans; 
    }
}