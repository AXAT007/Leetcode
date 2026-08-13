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
    public ListNode middleNode(ListNode head) {
        if(head.next==null){
            return head;
        }
        return f(head,head);
    }
    ListNode f(ListNode slow,ListNode fast){

        if(fast==null||fast.next==null){
            return slow;
        }
        
        ListNode next=f(slow.next,fast.next.next);


        
        return next;












        // else{
        //     if(c.val/2)
        // }









        // if(n.val==-1){
        // return new ListNode(-1);
        // }
        // if(c.val%2!=0){
        //     if(c.val/2==l){
        //         return h;
        //     }
        // }
        // else{
        //     if(c.val/2+1==l){
        //         return h;
        //     }
        // }
        
        // return n;
    }
}