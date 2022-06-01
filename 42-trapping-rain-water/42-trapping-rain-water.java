class Solution {
    public int trap(int[] h) {
        
        int n = h.length;
        int[] l = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && h[i] > st.peek()){
                st.pop();
                st.push(h[i]);
            }
            if(st.isEmpty()) st.push(h[i]);
            l[i] = st.peek();
        }
        
        int[] r = new int[n];
        st = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && h[i] > st.peek()){
                st.pop();
                st.push(h[i]);
            }
            if(st.isEmpty()) st.push(h[i]);
            r[i] = st.peek();
        }
        
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            int min = Math.min(l[i], r[i]);
            ans += (min - h[i]);
        }
        
        return ans;
    }
}