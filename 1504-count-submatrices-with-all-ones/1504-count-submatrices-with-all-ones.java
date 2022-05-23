class Solution {
    public int numSubmat(int[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;
        int r = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0 && j != 0){
                    arr[i][j] += arr[i][j - 1];
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0){
                    int s = Integer.MAX_VALUE;
                    for(int k = i; k >= 0; k--){
                        if(s > arr[k][j])
                            s = arr[k][j];
                            r += s;
                    }
                }
            }
        }
        return r;
    }
}