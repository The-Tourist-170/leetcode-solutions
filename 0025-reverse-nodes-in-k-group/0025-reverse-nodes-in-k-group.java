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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ch = head;
        ListNode cur = ch;
        ListNode p = null;
        
        int n = count(head) / k;
        System.out.println(n);
        
        for(int i = 0; i < n; i++){

            int nk = k;
            if(ch == head){
            
                while(cur != null && cur.next != null && nk > 1){
                
                    cur = cur.next;
                    nk--;
                }
                
                ListNode f = cur.next;
                cur.next = null;
                ch = reverseList(ch);
                cur = ch;
                
                while(cur != null && cur.next != null){
                    cur = cur.next;
                }

                cur.next = f;
                head = ch;
                ch = cur.next;
                p = cur;
                cur = ch;
                
            }else{
                
                while(cur != null && cur.next != null && nk > 1){

                    cur = cur.next;
                    nk--;
                }
                
                ListNode f = cur.next;
                cur.next = null;
                p.next = null;
                ch = reverseList(ch);
                p.next = ch;
                cur = ch;
                
                while(cur != null && cur.next != null){
                
                    cur = cur.next;
                }

                cur.next = f;
                ch = cur.next;
                p = cur;
                cur = ch;
            }
        }
        
        
        return head;
    }
    
    public int count(ListNode head){
        ListNode curr = head;
        int c = 0;
        while(curr != null){
            curr = curr.next;
            c++;
        }
        System.out.println(c+1);
        return c++;
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
}