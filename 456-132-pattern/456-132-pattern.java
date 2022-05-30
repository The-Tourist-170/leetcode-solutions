class Solution {
    public boolean find132pattern(int[] arr) {
        
        boolean flag = false;
        int n = arr.length;
        
        int[] m = new int[n];
        Stack<Integer> st = new Stack<>();
        m[0] = arr[0];
        
        for(int i = 1; i < n; i++) m[i] = Math.min(arr[i], m[i - 1]);
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!st.isEmpty() && m[i] >= st.peek()) st.pop();
            
            if(!st.isEmpty() && arr[i] > st.peek()){
                flag = true;
                break;
            }
            
            st.push(arr[i]);
        }
        
        return flag;
    }
}