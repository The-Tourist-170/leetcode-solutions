class Solution {
    public int maxChunksToSorted(int[] arr) {
        int c = 0, m = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > m)
                m = arr[i];
        
            if(m == i)
                c++;
        }
        return c;
    }
}