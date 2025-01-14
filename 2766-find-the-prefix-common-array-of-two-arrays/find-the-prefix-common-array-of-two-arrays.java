class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] cA = new int[n+1];
        int[] cB = new int[n+1];
        for(int i=0;i<n;i++) {
            cA[A[i]]++;
            cB[B[i]]++;
            for(int j=1;j<=n;j++) {
                res[i]+=Math.min(cA[j], cB[j]);
            }
        }
        return res;
    }
}