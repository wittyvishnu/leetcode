/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new ArrayDeque<>();
        if(root==null)return root;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=1;i<=size;i++){
                Node temp=q.poll();
               if(temp.left!=null) {
                q.offer(temp.left);
                q.offer(temp.right);
               }
               if(i!=size)
               temp.next=q.peek();
               else
               temp.next=null;
                
            }
            
        }
        return root;

    }

}