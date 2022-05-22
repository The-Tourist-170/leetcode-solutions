class StockSpanner {
    
    public class pair{
        int price;
        int idx;
    }
    
    Stack<pair> st;
    int t = 0;

    public StockSpanner() {
        st = new Stack<>();
        pair base = new pair();
        base.price = 100001;
        base.idx = -1;
        st.push(base);
    }
    
    public int next(int price) {
        pair p = new  pair();
        p.price = price;
        p.idx = t;
        t++;
        
        while(st.peek().price <= p.price){
            st.pop();
        }
        
        int ans = p.idx - st.peek().idx;
        st.push(p);
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */