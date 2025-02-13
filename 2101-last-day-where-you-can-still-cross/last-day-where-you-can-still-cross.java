class Solution {

    private int diff[][] = new int[][] {{-1, -1}, {-1, 0}, {-1,1}, {0, -1}, {0, 1} , {1, -1}, {1, 0}, {1, 1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        int[] setarr = new int[row*col+2];
        for(int i=0;i<=row*col+1;i++) {
            setarr[i] = i;
        }
        boolean[] water = new boolean[row*col];
        int days = 0;
        for(int cell[]:cells) {
            int r = cell[0]-1;
            int c = cell[1]-1;
            water[getCellIndex(r, c, col)-1] = true;
            for(int i=0;i<8;i++) {
                int ar = r+diff[i][0];
                int ac = c+diff[i][1];
                if(ar>=0&&ar<row&&ac>=0&&ac<col) {
                    if(water[getCellIndex(ar, ac, col)-1]) {
                        join(setarr, getCellIndex(r, c, col), getCellIndex(ar, ac, col));
                    }
                    if(c==0) {
                        join(setarr, 0, getCellIndex(r, c, col));
                    }
                    else if(c==col-1) {
                        join(setarr, row*col+1, getCellIndex(r, c, col));
                    }
                }
            }
            if(setarr[find(setarr, 0)]==setarr[find(setarr, row*col+1)]) {
                break;
            }
            days++;
        }
        return days;
    }

    private int getCellIndex(int row, int col, int c) {
        return row*c+col+1;
    }

    private void join(int setarr[], int a, int b) {
        setarr[find(setarr, a)] = setarr[find(setarr, b)];

    }

    private int find(int[] setarr, int i) {
        if(setarr[i]!=i) {
            setarr[i] = find(setarr, setarr[i]);
        }
        return setarr[i];
    }
}