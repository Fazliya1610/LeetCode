class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            int j = i+1;
            int k = n-1;
            while(j<k) {
                if(nums[i]+nums[j]+nums[k]==0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    res.add(l);
                    j++;
                    while(nums[j]==nums[j-1] && j<k) {
                        j++;
                    }
                }
                else if(nums[i]+nums[j]+nums[k]>0) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        list.addAll(res);
        return list;
    }
}