class Solution {
    int MOD = 1000000007;
    public int kInversePairs(int n, int k) {
        int[][] p = new int[n+1][k+1];
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=k;j++) {
                if(j==0) {
                    p[i][j] = 1;
                }
                else {
                    for(int l=0;l<=Math.min(j,i-1);l++) {
                        p[i][j] = (p[i][j]+p[i-1][j-l])%MOD;
                    }
                }
            }
        }
        return p[n][k];
    }
}