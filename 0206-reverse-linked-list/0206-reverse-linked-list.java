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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode ans=new ListNode(0);        
        rec(head,ans);
         return ans.next;
    }
    ListNode rec(ListNode curr,ListNode nHead){
        if(curr.next==null){
              nHead.next=curr;
            return curr;
        }
        ListNode next=rec(curr.next,nHead);
        next.next=curr;
        curr.next=null;
        return curr;
    }
}