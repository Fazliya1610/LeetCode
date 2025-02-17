class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutations(nums, res, 0);
        return res;
    }
    private void permutations(int[] nums, List<List<Integer>> res, int index) {
        if(index==nums.length) {
            res.add(convert(nums));
            return;
        }
        for(int i=index;i<nums.length;i++) {
            swap(nums, index, i);
            permutations(nums, res, index+1);
            swap(nums, index, i);
        }
        return;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private List<Integer> convert(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums) {
            list.add(num);
        }
        return list;
    }
}
