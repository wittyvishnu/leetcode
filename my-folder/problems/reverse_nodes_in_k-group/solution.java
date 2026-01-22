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
        ListNode before=dummy;
        ListNode temp=head;
        if(head==null||head.next==null)return head;
        while(true){
        for(int i=1;i<k &&temp!=null;i++)
        temp=temp.next;
        if(temp==null)break;
        ListNode oldHead=before.next;
        ListNode prev=temp.next;
        temp=before.next;
        for(int i=1;i<=k;i++){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        before.next=prev;
        before=oldHead;
        temp=before.next;
        
        
        }
        return dummy.next;
    }
   
}