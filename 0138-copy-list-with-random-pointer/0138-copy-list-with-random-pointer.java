/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node extract(Node head){
        Node dummy = new Node(-1);
        Node p = dummy, c = head;
        
        while(c != null){
            p.next = c.next;
            c.next = c.next.next;
            
            p = p.next;
            c = c.next;
        }
        
        return dummy.next;
    }
    
    public void copyRanPtr(Node head){
        Node c = head;
        while(c != null){
            Node r = c.random;
            if(r != null){
                c.next.random = r.next;
            }
            
            c = c.next.next;
        }
    }
    
    public void copyPtr(Node head){
        Node c = head;
        
        while(c != null){
            Node n = new Node(c.val);
            Node f = c.next;
            
            c.next = n;
            n.next = f;
            
            c = f;
        }
    }
    
    public Node copyRandomList(Node head) {
        copyPtr(head);
        copyRanPtr(head);
        return extract(head);
    }
}