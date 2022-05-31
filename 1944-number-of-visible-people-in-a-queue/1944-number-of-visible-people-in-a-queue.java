class Solution {
    public int[] canSeePersonsCount(int[] h) {
        
        int n = h.length;
        int[] arr = new int[n];
        
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0;  i--){
            int c = 0;            
            while(!st.isEmpty() && h[i] > st.peek()){
                st.pop();
                c++;
            }
            if(!st.isEmpty()) c++;
            arr[i] = c;
            st.push(h[i]);
        }
        return arr;
    }
}