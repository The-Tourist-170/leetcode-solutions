class Solution {
    
    public static int[] nseL(int[] n){
        
        int[] res = new int[n.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n.length; i++){
            while(!st.isEmpty() && n[i] <= n[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        
        return res;
    }
    
    public static int[] nseR(int[] n){
        
        int[] res = new int[n.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = n.length - 1; i >= 0; i--){
            while(!st.isEmpty() && n[i] <= n[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = n.length;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        
        return res;
    }
    
    public int maxSumMinProduct(int[] nums) {
        
        int n = nums.length;
        
        long[] pSum = new long[n+1];
        for(int i = 0; i < n; i++){
            pSum[i+1] = pSum[i] + nums[i];
        }
        
        int[] nsel = nseL(nums);
        int[] nser = nseR(nums);
        long max = Long.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            int rr = nser[i];
            int lr = nsel[i];
            long sum = (pSum[rr] - pSum[lr + 1]) * nums[i];
            max = Math.max(max, sum);
        }
        
        return (int)(max%1000000007);
        
    }
}