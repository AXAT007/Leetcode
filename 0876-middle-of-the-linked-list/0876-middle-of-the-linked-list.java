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
        return f(head,new ListNode(1),1);
    }
    ListNode f(ListNode h,ListNode c,int l){

        if(h.next==null){
            if(c.val/2+1==l){
            return h;
        }
            return new ListNode(-1);
        }
        c.val+=1;
        ListNode next=f(h.next,c,l+1);
        if(next.val!=-1){
            return next;
        }
        if(c.val/2+1==l){
            return h;
        }
        
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