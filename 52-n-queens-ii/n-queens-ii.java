class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        char[][] q = new char[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(q[i], '.');
        }
        solve(n, res, q, 0);
        return res[0];
    }

    private void solve(int n, int[] res, char[][] q, int row) {
        if(row==n) {
            res[0]++;
            return;
        }
        for(int col=0;col<n;col++) {
            if(safe(n, q, row, col)) {
                q[row][col] = 'Q';
                solve(n, res, q, row+1);
                q[row][col] = '.';
            }
        }
    }

    private boolean safe(int n, char[][] q, int row, int col) {
        for(int i=0;i<n;i++) {
            if(q[i][col]=='Q') {
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--, j--) {
            if(q[i][j]=='Q') {
                return false;
            }
        }
        for(int i=row-1, j=col+1;i>=0&&j<n;i--,j++) {
            if(q[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }
}