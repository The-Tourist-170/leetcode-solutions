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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        else if(lists.length == 1){
            if(lists[0] == null){
                return null;
            }    
        }
            
        for(int i = 0; i < lists.length - 1; i++){
            ListNode l1 = lists[i];
            ListNode l2 = lists[i+1];
            ListNode merge = mergeTwoLists(l1, l2);
            lists[i+1] = merge;
        }
        
        return lists[lists.length - 1];
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
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