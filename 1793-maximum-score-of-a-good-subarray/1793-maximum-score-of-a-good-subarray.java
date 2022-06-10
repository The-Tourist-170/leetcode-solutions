class Solution {
    
    public static int[] lse(int[] n){
        
        int[] arr = new int[n.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n.length; i++){
            while(!st.isEmpty() && n[i] <= n[st.peek()]){
                st.pop();
            }
            
            if(st.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = st.peek();
            }
            st.push(i);
        }
        
        return arr;
    }
    
    public static int[] rse(int[] n){

        int[] arr = new int[n.length];
        Stack<Integer> st = new Stack<>();

        for(int i = n.length-1; i >= 0; i--){
            while(!st.isEmpty() && n[i] <= n[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                arr[i] = n.length;
            }else{
                arr[i] = st.peek();
            }
            st.push(i);
        }
        
        return arr;
    }
        
    public int maximumScore(int[] nums, int k) {
        
        int[] rs= rse(nums);
        int[] ls= lse(nums);
        int s = 0;
        
        for(int i = 0; i < nums.length; i++){
            int l = ls[i];
            int r = rs[i];
            
            if(l+1 <= k && r-1 >=k){
                s = Math.max(s, nums[i] * (r-l-1));
            }
        }
        
        return s;
    }
}