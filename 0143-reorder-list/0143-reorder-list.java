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

      ListNode mid = midNode(head);
      ListNode h2 = reverseList(mid.next);
      mid.next = null;

      ListNode c1 = head;
      ListNode c2 = h2;
      ListNode f1 = null;
      ListNode f2 = null;


      while(c2 != null){
        f1 = c1.next;
        f2 = c2.next;

        c1.next = c2;
        c2.next = f1;

        c1 = f1;
        c2 = f2;
      }

    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode c = head;
        ListNode p = null;
        ListNode f = null;

        while(c != null){
            f = c.next;
            c.next = p;

            p = c;
            c= f;
        }     
        
        return p;
    }
    
    public static ListNode midNode(ListNode head) {

        ListNode ptr = head;
        int c = count(head);
        if(c%2 != 0){
          c = (c+1)/2;
          while(c > 1){
            ptr = ptr.next;
            c--;
          }
        }else{
          c = (c / 2) + 1;
          while(c > 1){
            ptr = ptr.next;
            c--;
          }
        }

        return ptr;
    }
    
    public static int count(ListNode head){
        int c = 0;
        ListNode curr = head;
        while(curr != null){
          curr = curr.next;
          c++;
        }

        return c;
    }
}