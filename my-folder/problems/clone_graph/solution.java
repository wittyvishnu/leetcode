/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map=new HashMap<>();//original,clone
        Queue<Node> q=new ArrayDeque<>();
        if(node==null)return null;
        q.offer(node);
        Node temp=new Node(node.val);
        map.put(node,temp);
        while(!q.isEmpty()){
            Node first=q.poll();
            Node second=map.get(first);
            for(Node neigh:first.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh,new Node(neigh.val));
                    q.offer(neigh);
                }
                second.neighbors.add(map.get(neigh));
            }
        }
        return temp;
    }
}