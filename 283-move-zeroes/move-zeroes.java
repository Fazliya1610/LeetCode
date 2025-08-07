class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(nums[i]!=0) {
                l.add(nums[i]);
            }
        }
        for(int i=0;i<l.size();i++) {
            nums[i] = l.get(i);
        }
        for(int i=l.size();i<n;i++) {
            nums[i] = 0;
        }
    }
}