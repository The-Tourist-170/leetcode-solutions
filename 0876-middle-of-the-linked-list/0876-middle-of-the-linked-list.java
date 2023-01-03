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
class Solution{
    public ListNode middleNode(ListNode head) {

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