class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prevIndex = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndex, -1);
        int maxLen = 1;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> subset = new ArrayList<>();
        int index = maxIndex;
        while (index != -1) {
            subset.add(nums[index]);
            index = prevIndex[index];
        }
        return subset;
    }
}