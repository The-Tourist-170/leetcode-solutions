class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        int[] arr = new int[t.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < t.length; i++){
            
            while(!st.empty() && t[i] > t[st.peek()]){
                arr[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return arr;
    }
}