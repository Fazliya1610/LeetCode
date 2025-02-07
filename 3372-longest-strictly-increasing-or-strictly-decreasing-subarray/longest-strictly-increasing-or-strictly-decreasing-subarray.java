class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1 , dec = 1, max = 1;
        for(int i=0;i<nums.length-1; i++) {
            if(nums[i]<nums[i+1]) {
                inc++;
            }
            else {
                max = Math.max(max, inc);
                inc = 1;
            }
            if(nums[i]>nums[i+1]) {
                dec++;
            }
            else {
                max = Math.max(max, dec);
                dec = 1;
            }
        }
        max = Math.max(max, inc);
        max = Math.max(max, dec);
        return max;
    }
}