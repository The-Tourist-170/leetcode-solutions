class Solution {
    public int maxChunksToSorted(int[] arr) {

        int len = arr.length;
        int lmax[] = new int[len+1];
        int rmin[] = new int[len+1];

        lmax[0] = arr[0];
        rmin[len] = Integer.MAX_VALUE;

        int count = 0;
        for(int i = 1; i<len; i++){
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }
        for(int i = len-1; i>=0; i--){
            rmin[i] = Math.min(rmin[i+1], arr[i]);
        }
        for(int i = 0; i<len; i++){
            if(lmax[i] <= rmin[i+1])
                count++;
        }
        return count;
    }
}