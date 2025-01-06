class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for(int i=0;i<=n-m;i++) {
            int j = 0;
            while(j<m&&needle.charAt(j)==haystack.charAt(j+i)) {
                j++;
            }
            if(j==m) {
                return i;
            }
        }
        return -1;
    }
}