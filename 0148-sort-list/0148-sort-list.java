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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }
     
    public ListNode merge(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;

        while(c1 != null && c2 != null){
          if(c2.val < c1.val){
            prev.next = c2;
            c2 = c2.next;
          }else{
            prev.next = c1;
            c1 = c1.next;
          }
          prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;

        return dummy.next;
    }
}