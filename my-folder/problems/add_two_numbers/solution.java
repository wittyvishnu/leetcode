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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        int carry=0;
        while(l1!=null&&l2!=null){
            int sum=carry+l1.val+l2.val;
            l1=l1.next;
            l2=l2.next;
            ListNode current=new ListNode(sum%10);
            carry=sum/10;
            temp.next=current;
            temp=current;
            
        }
        while(l1!=null){
            int sum=carry+l1.val;
            l1=l1.next;
            ListNode current=new ListNode(sum%10);
            carry=sum/10;
            temp.next=current;
            temp=current;
        }
        while(l2!=null){
            int sum=carry+l2.val;
            l2=l2.next;
            ListNode current=new ListNode(sum%10);
            carry=sum/10;
            temp.next=current;
            temp=current;
        }
        if(carry!=0)
        temp.next=new ListNode(carry);
        return dummy.next;
    }
}