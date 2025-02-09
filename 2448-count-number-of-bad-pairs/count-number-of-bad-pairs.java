class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long tot = (long)n*(n-1)/2;
        Map<Integer, Long> diff = new HashMap<>();
        for(int i=0;i<n;i++) {
            int d = nums[i]-i;
            tot-=diff.getOrDefault(d,0L);
            diff.put(d, diff.getOrDefault(d, 0L)+1);
        }
        return tot;
    }
}