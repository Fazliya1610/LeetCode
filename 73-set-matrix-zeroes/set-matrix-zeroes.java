class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] b = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    for(int k=0;k<m;k++) {
                        if(matrix[k][j]!=0) {
                            b[k][j] = true;
                        }
                    }
                    for(int k=0;k<n;k++) {
                        if(matrix[i][k]!=0) {
                            b[i][k] = true;
                        }
                    }
                }
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(b[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}