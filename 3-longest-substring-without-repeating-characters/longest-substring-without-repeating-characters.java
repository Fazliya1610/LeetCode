class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) {
            return s.length();
        }
        int res = 0;
        boolean[] vis = new boolean[128];
        int left = 0, right = 0;
        while(right<s.length()) {
            while(vis[s.charAt(right)]==true) {
                vis[s.charAt(left)] = false;
                left++;
            }
            vis[s.charAt(right)] = true;
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}