class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] r = new int[m];
        int[] c = new int[n];
        for(int i=0;i<m;i++) {
            r[i] = Integer.MAX_VALUE;
        }
        for(int j=0;j<n;j++) {
            c[j] = Integer.MIN_VALUE;
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]<r[i]) {
                    r[i] = matrix[i][j];
                }
            }
        }
        for(int j=0;j<n;j++) {
            for(int i=0;i<m;i++) {
                if(matrix[i][j]>c[j]) {
                    c[j] = matrix[i][j];
                }
            }
        }
        List<Integer> luck = new ArrayList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==r[i]&&matrix[i][j]==c[j]) {
                    luck.add(matrix[i][j]);
                }
            }
        }
        return luck;
    }
}