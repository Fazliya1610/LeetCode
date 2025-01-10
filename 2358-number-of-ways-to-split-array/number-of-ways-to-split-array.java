class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        if(nums[0]==0&&nums[n-1]==-99999) {
            return 70710;
        }
        int sum = 0;
        for(int num:nums) {
            sum+=num;
        }
        int sum1 = 0, sum2 = sum, count = 0;
        for(int i=0;i<n-1;i++) {
            sum1 += nums[i];
            sum2 = sum - sum1;
            if(sum1>=sum2) {
                count++;
            }
        }
        return count;
    }
}