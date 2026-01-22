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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode last;
        ListNode first=head;
        ListNode temp=new ListNode(-1);
        if(head==null || head.next==null || head.next.next==null)return;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        last=reverse(slow.next);
        slow.next=null;
        while(last!=null){
            temp.next=first;
            first=first.next;
            temp.next.next=last;
            last=last.next;
            temp=temp.next.next;

        }
        if(first!=null){
            temp.next=first;
            first=first.next;
        }


    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode front;
        while(head!=null){
            front=head.next;
            head.next=prev;
            prev=head;
            head=front;
        }
        return prev;
    }
}