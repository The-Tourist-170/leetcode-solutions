class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int min = nums[0];
        int max = nums[0];
        int j = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            
            // With change of i the range changes so 
            // recompted min max
            if (nums[i] < nums[i + 1]) {
                min = nums[i]; max = nums[i + 1];
            } else {
                min = nums[i + 1]; max = nums[i];                
            }
                
            for ( j = i + 1; j < nums.length; j++) {
                
                // In j loop the range will be same so 
                // and i will be fixed so update the 
                // min max only if j affets min max
                if (nums[j] < min)  {
                    min =  nums[j];                
                } else if (nums[j] > max) {
                    max = nums[j];
                }
                sum += max - min;
            }
        }
        
        return sum;
    }
}