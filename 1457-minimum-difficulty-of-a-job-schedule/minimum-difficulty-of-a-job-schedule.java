class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d){
            return -1;
        }
        int[][] a=new int[n][d+1];
        a[0][1]=jobDifficulty[0];
        for(int i=1;i<n;i++){
            a[i][1]=Math.max(a[i-1][1],jobDifficulty[i]);
        }
        for(int i=2;i<=d;i++){
            for(int j=i-1;j<n;j++){
                a[j][i]=Integer.MAX_VALUE;
                int m=0;
                for(int k=j;k>=i-1;k--){
                    m=Math.max(m,jobDifficulty[k]);
                    a[j][i]=Math.min(a[j][i],a[k-1][i-1]+m);
                }
            }
        }
        return a[n-1][d];
    }
}