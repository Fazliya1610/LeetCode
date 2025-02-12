class Solution {
    public int maximumSum(int[] nums) {
        int max = -1;
        int[] dp = new int[82];
        Arrays.fill(dp, -1);
        for(int num:nums) {
            int s = 0, t = num;
            while(t>0) {
                s+=t%10;
                t/=10;
            }
            if(dp[s]!=-1) {
                max = Math.max(max, num+dp[s]);
            }
            dp[s] = Math.max(dp[s], num);
        }
        return max;
    }
}