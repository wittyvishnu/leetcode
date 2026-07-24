/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode groupTail=dummy;
        ListNode temp=head;
        while(true){
            for(int i=1;i<k&&temp!=null;i++)
            temp=temp.next;
            if(temp==null)break;
            ListNode nextGroup=temp.next;
            ListNode currentGroupTail=groupTail.next;
            temp.next=null;
            groupTail.next=reverse(groupTail.next);
            groupTail=currentGroupTail;
            groupTail.next=nextGroup;
            temp=nextGroup;


        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}