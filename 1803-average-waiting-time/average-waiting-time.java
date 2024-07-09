class Solution {
    public double averageWaitingTime(int[][] customers) {
        int curr = 0;
        double tot = 0;
        for(int[] c:customers) {
            int a = c[0];
            int t = c[1];
            if(curr<a) {
                curr = a;
            }
            curr+=t;
            tot+=(curr-a);
        }
        return tot/customers.length;
    }
}