class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int num:nums) {
            s.add(num);
        }
        int res = 0;
        for(int num:nums) {
            if(s.contains(num)&&!s.contains(num-1)) {
                int curr = num, count = 0;
                while(s.contains(curr)) {
                    s.remove(curr);
                    curr++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}