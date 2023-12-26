class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD=1000000007;
        int[][] w=new int[n+1][target+1];
        w[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                for(int l=1;l<=k;l++){
                    if(j-l>=0){
                        w[i][j]=(w[i][j]+w[i-1][j-l])%MOD;
                    }
                }
            }
        }
        return w[n][target];
    }
}