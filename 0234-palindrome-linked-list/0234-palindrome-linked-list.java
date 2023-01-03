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

        int c = count(head);
        boolean flag = true;

        ListNode ll1 = head;
        ListNode ll2 = null;

        if(c % 2 != 0){
          c = ((c + 1) / 2) - 1;
          ll2 = reverseList(midNode(head).next);

        }else{
          c = c / 2;
          ll2 = reverseList(midNode(head));
        }

        while(c-- > 0){
          if(ll1.val != ll2.val){
            flag = false;
          }
            ll1 = ll1.next;
            ll2 = ll2.next;
        }

        return flag;
    }

    public ListNode reverseList(ListNode head) {
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
    
    public ListNode midNode(ListNode head) {

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
    
    public int count(ListNode head){
        int c = 0;
        ListNode curr = head;
        while(curr != null){
          curr = curr.next;
          c++;
        }

        return c;
    }
}