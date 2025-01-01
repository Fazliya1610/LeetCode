class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] curr = intervals[0];
        merged.add(curr);
        for(int[] in:intervals) {
            int end = curr[1];
            int ns = in[0];
            int ne = in[1];
            if(ns<=end) {
                curr[1] = Math.max(end, ne);
            }
            else {
                curr = in;
                merged.add(curr);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}