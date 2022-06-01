class Solution {
    public int minNumberOperations(int[] t) {
        
        int o = t[0];
        for(int i = 1; i < t.length; i++)
            if(t[i] <= t[i - 1]){
                o += 0;
            }else{
                o += t[i] - t[i - 1];
            }
        
        return o;
    }
}