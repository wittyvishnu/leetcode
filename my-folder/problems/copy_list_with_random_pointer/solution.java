/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=new Node(-1);
        Node temp=head;
        while(temp!=null){
            Node middle=new Node(temp.val);
            middle.next=temp.next;
            temp.next=middle;
            temp=middle.next;

        }
        temp=head;
        while(temp!=null){
            Node middle=temp.next;
            middle.random=(temp.random!=null)?temp.random.next:null;
            temp=middle.next;
        }
        temp=head;
        Node res=dummy;
        while(temp!=null){
         Node middle=temp.next;
         res.next=middle;
         res=res.next;
         temp.next=middle.next;
         temp=temp.next;
        }
        return dummy.next;
    }
}