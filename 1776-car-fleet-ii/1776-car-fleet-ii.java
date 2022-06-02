class Solution {
    
    public double[] getCollisionTimes(int[][] c) {
         
        int n = c.length;
        double[] ans = new double[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && c[i][1] <= c[st.peek()][1])
                st.pop();
            
            while(!st.isEmpty()){
                double cT = (c[st.peek()][0] - c[i][0]) / (double)(c[i][1] - c[st.peek()][1]);
                if(cT <= ans[st.peek()] || ans[st.peek()] == -1){
                    ans[i] = cT;
                    break;
                }
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}