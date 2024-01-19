class Solution {
    public int climbStairs(int n) {
        if(n<=2) {
            return n;
        }
        int[] step = new int[n+1];
        step[1] = 1;
        step[2] = 2;
        for(int i=3;i<=n;i++) {
            step[i] = step[i-1]+step[i-2];
        }
        return step[n];
    }
}