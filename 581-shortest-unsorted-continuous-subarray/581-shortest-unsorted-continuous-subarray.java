class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int e = -1;
        
        for(int i = 1; i <= n - 1; i++){
            if(max > nums[i]){
                e = i;
            }else{
                max = nums[i];
            }
        }
        
        int s = 0;
        int min = nums[n-1];
        for(int i = n - 2; i >= 0; i--){
            if(min < nums[i]){
                s = i;
            }else{
                min = nums[i];
            }
        }
        return e - s + 1;
    }
}