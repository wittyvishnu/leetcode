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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp;
        ListNode before=dummy;
        // ListNode after=null;
        if(left==right)return head;
        for(int i=1;i<left;i++)
        before=before.next;
        temp=before.next;
        ListNode prev=null;
        for(int i=1;i<=right-left+1;i++){
            ListNode after=temp.next;
            temp.next=prev;
            prev=temp;
            temp=after;
        }
        ListNode last=before.next;
        before.next=prev;
        last.next=temp;
        return dummy.next;

    }
}