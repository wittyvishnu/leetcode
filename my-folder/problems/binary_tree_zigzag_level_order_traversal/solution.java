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
       ArrayDeque<TreeNode> dq=new ArrayDeque<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root!=null)dq.addLast(root);
        boolean rightToLeft=false;
        while(!dq.isEmpty()){
            int size=dq.size();
            List<Integer> level=new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode temp=dq.pollFirst();
                if(rightToLeft) level.add(0,temp.val);
                else level.add(temp.val);
                if(temp.left!=null)dq.addLast(temp.left);
                if(temp.right!=null)dq.addLast(temp.right);
            }
            ans.add(level);
            rightToLeft=!rightToLeft;
        }
        return ans;
    }
}