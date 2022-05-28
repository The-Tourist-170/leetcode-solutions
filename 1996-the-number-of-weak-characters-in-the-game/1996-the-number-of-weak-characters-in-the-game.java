class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        
        int n = p.length, w = 0, min = Integer.MIN_VALUE;
        Arrays.sort(p, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        for(int i = 0; i < n; i++){
            int[] arr = p[i];
            int a = arr[0];
            int d = arr[1];
            if(min > d)
                w++;
            min = Math.max(min,d);
        }
        return w;
        
    }
}