class Solution {
    public int[] finalPrices(int[] arr) {
         
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        int[] ans = new int[arr.length];
        
        for(int i = 1; i < arr.length; i++){
            while(st.size() != 0 && arr[i] <= arr[st.peek()]){
                
                ans[st.peek()] = arr[st.peek()] - arr[i];
                st.pop();
            }
            st.push(i);
        }
        
        while(st.size() != 0){
            int v = st.pop();
            ans[v] = arr[v];
        }
        return ans;
    }
}