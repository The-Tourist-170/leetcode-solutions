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
        ListNode dummy = new ListNode(-1);
        var c = 0;
        ListNode h1 = l1, h2 = l2, dh = dummy;
        
        while(h1 != null && h2 != null){
            var d = c + h1.val + h2.val;
            ListNode t = new ListNode(d % 10);
            dh.next = t;
            c = d / 10;
                        
            h1 = h1.next;
            h2 = h2.next;
            dh = dh.next;
        }
        ListNode th = null;
        if(h1 == null){
            th = h2;
        }else{
            th = h1;
        }
        
        while(th != null){
            var d = c + th.val;
            ListNode t = new ListNode(d % 10);
            dh.next = t;
            c = d / 10;
            
            th = th.next;
            dh = dh.next;
        }
        
        if(c > 0){
            ListNode t = new ListNode(c);
            dh.next = t;
        }
        return dummy.next;
    }
}