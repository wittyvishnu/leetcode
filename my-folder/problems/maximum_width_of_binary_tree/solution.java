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
    public int widthOfBinaryTree(TreeNode root) {
        int max=0;
        Deque<Pair<TreeNode,Integer>> dq=new ArrayDeque<>();
        if(root==null)return max;
        dq.offer(new Pair<>(root,1));
        while(!dq.isEmpty()){
            int width=dq.peekLast().getValue()-dq.peekFirst().getValue()+1;
            max=(max<width)?width:max;
            int size=dq.size();
            for(int i=1;i<=size;i++){
                Pair<TreeNode,Integer> temp=dq.pollFirst();
                if(temp.getKey().left!=null) dq.offerLast(new Pair<>(temp.getKey().left,temp.getValue()*2));
                if(temp.getKey().right!=null) dq.offerLast(new Pair<>(temp.getKey().right,temp.getValue()*2+1));

            }

        }
        return max;
    }
}