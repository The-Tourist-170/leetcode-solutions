class Solution {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        int[] ind = new int[10000];
        int[] arr = new int[n2.length];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }
        for(int i = 0; i < n2.length; i++){
            ind[n2[i]] = i;
        }
        
        
        for(int i = 1; i < n2.length; i++){
            
            while(st.size() != 0 && n2[i] > n2[st.peek()]){
                
                arr[st.peek()] = n2[i];
                st.pop();
            }
            st.push(i);
        }
        
        for(int i = 0; i < n1.length; i++){
            n1[i] = arr[ind[n1[i]]];
        }
        
        
        
        return n1;
    }
}