class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuilder str = new StringBuilder(s);
        String rev = str.reverse().toString();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=rev.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}