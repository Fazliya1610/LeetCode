class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] pre = new int[r][c+1];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                pre[i][j+1] = pre[i][j]+matrix[i][j];
            }
        }
        int count = 0;
        for (int left=0;left<c;left++) {
            for (int right=left;right<c;right++) {
                Map<Integer, Integer> prefixSumMap = new HashMap<>();
                prefixSumMap.put(0, 1);
                int currentSum = 0;
                for (int row = 0; row < r; row++) {
                    currentSum += pre[row][right + 1] - pre[row][left];
                    if (prefixSumMap.containsKey(currentSum - target)) {
                        count += prefixSumMap.get(currentSum - target);
                    }
                    prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
                }
            }
        }
        return count;
    }
}