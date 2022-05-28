class Solution {
    public int longestWPI(int[] h) {
        
        int n = h.length;
        int[] r = new int[n];
        r[0] = (h[0] > 8) ? 1 : -1;
        
        for(int i = 1; i <= n - 1; i++)
            r[i] = (h[i] > 8 ? 1 : -1) + r[i - 1];
        
        int max = 0;
        for(int i = 0; i <= n - 1; i++)
            for(int j = i; j <= n - 1; j++)
                if(gSum(r, i, j) > 0)
                    max = Math.max(max, j - i + 1);
        
        return max;
    }
    
    public static int gSum(int[] R, int i, int j){
        int l = (i > 0) ? R[i - 1] : 0;
        int r = R[j];
        return r - l;
    }
}