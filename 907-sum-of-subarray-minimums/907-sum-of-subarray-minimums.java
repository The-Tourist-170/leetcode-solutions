class Solution {
    public int sumSubarrayMins(int[] arr) {
        int result = 0;
        // for(int i=0; i < arr.length; i++){
        //     for(int j = 0; j < arr.length;j++){
        //         if (j+i < arr.length)
        //             result += findMin(arr, j, j+i); 
        //             result = result%1_000_000_007;
        //     }
        // }
        int n = arr.length;
        int[] localSum = new int[n];
        int span = 0;
        Stack<Pair<Integer, Integer>> ms = new Stack<>();
        
        for (int i =0; i<n; i++){
            while (!ms.empty() && ms.peek().getKey() >= arr[i])
                ms.pop();

            if(!ms.empty()){
                span = i - ms.peek().getValue();
                localSum[i] = localSum[ms.peek().getValue()];
            } else {
                span = i+1;
            }
            localSum[i] = (localSum[i]+span * arr[i])%1_000_000_007;
            result += localSum[i];
            result %= 1_000_000_007;
            ms.push(new Pair(arr[i], i));
        }
        
        return result;
    }
    
    public int findMin(int[] arr, int start, int end){
        int result = Integer.MAX_VALUE;
        for (int i= start; i <= end; i++){
            result = Math.min(result, arr[i]);
        }
        
        return result;
    }
}