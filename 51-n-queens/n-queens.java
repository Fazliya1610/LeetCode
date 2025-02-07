class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] q = new char[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(q[i], '.');
        }
        solve(n, res, q, 0);
        return res;
    }

    private void solve(int n, List<List<String>> res, char[][] q, int row) {
        if(row==n) {
            List<String> sol = new ArrayList<>();
            for(char[] r:q) {
                sol.add(new String(r));
            }
            res.add(sol);
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
        for(int i=row-1,j=col-1; i>=0&&j>=0;i--, j--) {
            if(q[i][j]=='Q') {
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--, j++) {
            if(q[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }
}