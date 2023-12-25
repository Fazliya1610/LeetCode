class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> r=new ArrayList<>();
        Arrays.sort(nums);
        sub(r,new ArrayList<>(),nums,0);
        return r;
    }
    private static void sub(List<List<Integer>> r, List<Integer> s,int[] nums, int st){
        r.add(new ArrayList<>(s));
        for(int i=st;i<nums.length;i++){
            if(i>st&&nums[i]==nums[i-1]){
                continue;
            }
            s.add(nums[i]);
            sub(r,s,nums,i+1);
            s.remove(s.size()-1);
        }
    }
}