class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        help(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private void help(LinkedList<Integer> l, int index, int[] nums, List<List<Integer>> res) {
        if(l.size()>1) {
            res.add(new LinkedList<Integer>(l));
        }
        Set<Integer> u = new HashSet<>();
        for(int i=index;i<nums.length;i++) {
            if(!u.contains(nums[i])&&(l.size()==0||nums[i]>=l.peekLast())) {
                u.add(nums[i]);
                l.add(nums[i]);
                help(l, i+1, nums, res);
                l.remove(l.size()-1);
            }
        }
    }
}