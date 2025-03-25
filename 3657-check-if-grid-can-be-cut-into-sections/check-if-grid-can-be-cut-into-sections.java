class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int len = rectangles.length;
        int[][] x = new int[len][2];
        int[][] y = new int[len][2];
        for(int i=0;i<len;i++) {
            x[i][0] = rectangles[i][0];
            x[i][1] = rectangles[i][2];
            y[i][0] = rectangles[i][1];
            y[i][1] = rectangles[i][3];
        }
        return check(x)||check(y);
    }

    private boolean check(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int sec = 0;
        int max = intervals[0][1];
        for(int[] in:intervals) {
            if(max<=in[0]) {
                sec++;
            }
            max = Math.max(max, in[1]);
        }
        return sec>=2;
    }
}