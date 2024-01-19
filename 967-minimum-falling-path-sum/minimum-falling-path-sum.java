class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] sum = new int[n][n];
        for(int i=0;i<n;i++) {
            sum[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++) {
            for(int j=0;j<n;j++) {
                sum[i][j]=matrix[i][j]+Math.min(sum[i-1][j],Math.min(sum[i-1][Math.max(0,j-1)],sum[i-1][Math.min(n-1,j+1)]));
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int j=0;j<n;j++) {
            minSum = Math.min(minSum, sum[n-1][j]);
        }
        return minSum;  
    }
}