class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, left = 0, right = 0, i = 0;
        while(i<s.length()) {
            if(s.charAt(i)=='(') {
                left++;
            }
            else {
                right++;
            }
            if(left<right) {
                left = 0;
                right = 0;
            }
            else if(left==right) {
                max = Math.max(max, left*2);
            }
            i++;
        }
        left = 0;
        right = 0;
        for(i=s.length()-1;i>=0;i--) {
            if(s.charAt(i)=='(') {
                left++;
            }
            else {
                right++;
            }
            if(left>right) {
                left = 0;
                right = 0;
            }
            else if(left==right) {
                max = Math.max(max, left*2);
            }
        }
        return max;
    }
}