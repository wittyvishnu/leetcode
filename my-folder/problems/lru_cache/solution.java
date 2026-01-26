class Node{
    public int k;
    public int v;
    Node prev,next;
    Node(){
        k=v=-1;
        prev=next=null;
    }
    Node(int k,int v){
        this.k=k;
        this.v=v;
        next = prev = null;
    }
}
class LRUCache {
    private int cap;
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> map;
    private Node DeleteNode(Node temp){
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        return temp;
    }
    private Node InsertNode(Node temp){
        tail.prev.next=temp;
        temp.prev=tail.prev;
        temp.next=tail;
        tail.prev=temp;
        return temp;
    }
    public LRUCache(int capacity) {
        cap = capacity; 
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp=DeleteNode(map.get(key));
            return InsertNode(temp).v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            temp.v=value;
            DeleteNode(temp);
            map.put(key,InsertNode(temp));
            return;
        }
        if(map.size()==cap){
            Node temp=DeleteNode(head.next);
            map.remove(temp.k);
            temp.k=key;
            temp.v=value;
            map.put(key,InsertNode(temp));
            return;
        }
        Node n=new Node(key,value);
        map.put(key,InsertNode(n));

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */