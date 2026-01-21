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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if (head == null || head.next == null) return true;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)slow=slow.next;
        fast=reverse(slow);    
        slow=head;

    
        while(fast!=null){
        if(slow.val!=fast.val)return false;
        slow=slow.next;
        fast=fast.next;
        }
        return true;
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