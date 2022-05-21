class Solution {
    public int[] nextGreaterElements(int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && st.peek() <= arr[i]){
                st.pop();
            }
            st.push(arr[i]);
        }
        
        for(int i = arr.length - 1; i >= 0; i--){
            
            while(st.size() != 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.size() > 0){
                ans[i] = st.peek();
            }else{
                ans[i] = -1;
            }
            st.push(arr[i]);
        }
        return ans;
        
    }
}