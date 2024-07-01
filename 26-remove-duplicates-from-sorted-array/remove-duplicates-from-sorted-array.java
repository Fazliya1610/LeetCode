class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>();
        for(int i=0;i<nums.length;i++) {
            s.add(nums[i]);
        }
        int k = s.size();
        int i = 0;
        for(int n:s) {
            nums[i] = n;
            i++;
        }
        return k;
    }
}