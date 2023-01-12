//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
class GfG{
    public static Node[] merge(Node[] lsl, Node p, Node[] rsl){
        Node h = null, t = null;
        if(lsl[0] != null && rsl[0] != null){
            lsl[1].next = p;
            p.next = rsl[0];
            h = lsl[0]; t = rsl[1];
        }
        else if(lsl[0] != null){
            lsl[1].next = p;
            h = lsl[0]; t = p;
        }
        else if(rsl[0] != null){
            p.next = rsl[0];
            h = p; t = rsl[1];
        }else{
            h = t = p;
        }
        
        return new Node[] {h, t};
    }
    
    public static Node[] segList(Node h, int pi){
        Node p = h;
        while(pi-- > 0){
            p = p.next;
        }
        
        Node sh = new Node(-1), lh = new Node(-1);
        Node sc = sh, lc = lh, c = h;
        
        while(c != null){
            if(c != p){
                if(c.data <= p.data){
                    sc.next = c;
                    sc = sc.next;
                }else{
                    lc.next = c;
                    lc = lc.next;
                }
            }
            c = c.next;
        }
        
        sc.next = null; lc.next = null; p.next = null;
        
        return new Node[] {sh.next, p, lh.next};
    }
    
    public static int calc(Node h){
        if(h == null) return 0;
        Node c = h;
        var l = 0;
        while(c != null){
            l++;
            c = c.next;
        }
        
        return l;
    }
    
    public static Node[] qs(Node h){
        if(h == null || h.next == null) return new Node[] {h, h};
        
        var len = calc(h);
        var p = len/2;
        
        Node[] sl = segList(h, p);
        Node[] lsl = qs(sl[0]);
        Node[] rsl = qs(sl[2]);
        
        return merge(lsl, sl[1], rsl);
    }
    
    public static Node quickSort(Node node){
        //Your code here
        return qs(node)[0];
    }
}