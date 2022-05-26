class Solution {
    public int carFleet(int dt, int[] p, int[] s) {
        
        int n = p.length, f = 1;
        double[][] t = new double[n][2];
        
        for(int i = 0; i < n; i++){
            t[i][0] = p[i]*1d;
            t[i][1] = ((dt-p[i])*1d)/s[i];
        }
        
        Arrays.sort(t,(a,b)->(Double.compare(a[0],b[0])));
        double ct = t[n-1][1];
        for(int i = n - 2; i >= 0; i--){
            if(t[i][1] > ct){
                f++;
                ct = t[i][1];
            } 
        }        
        return f;
    }
}