class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        for(int i=0;i<nums.length;i++) {
            int sum = nums[i];
            for(int j=i;j<nums.length-1;j++) {
                if(nums[j]<nums[j+1]) {
                    sum+=nums[j+1];
                }
                else {
                    break;
                }
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}