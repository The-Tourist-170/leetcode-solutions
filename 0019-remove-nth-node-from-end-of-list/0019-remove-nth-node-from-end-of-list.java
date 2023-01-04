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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = curr.next;
        ListNode f = head;
        
        for(int i = 0; i < n - 1; i++){
            f = f.next;
        }
        
        while(f.next != null){
            f = f.next;
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
        }
        
        if(prev != null){
            prev.next = nxt;
        }else{
            head = nxt;
        }
        
        return head;
    }
}