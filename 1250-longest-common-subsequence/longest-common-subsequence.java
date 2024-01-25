class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] lcs = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }
                else {
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        return lcs[m][n];
    }
}