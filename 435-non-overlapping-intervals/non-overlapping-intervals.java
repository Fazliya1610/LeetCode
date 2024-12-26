class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        int prev = 0, rem = 0;
        for(int i=1;i<n;i++) {
            if(intervals[i][0]<intervals[prev][1]) {
                rem++;
            }
            else {
                prev = i;
            }
        }
        return rem;
    }
}