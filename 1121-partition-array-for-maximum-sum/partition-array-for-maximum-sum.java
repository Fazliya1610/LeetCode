class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            int max = 0;
            for(int j=1;j<=k&&i-j+1>=0;j++) {
                max = Math.max(max, arr[i-j+1]);
                res[i] = Math.max(res[i], (i>=j?res[i-j]:0)+max*j);
            }
        }
        return res[n-1];
    }
}