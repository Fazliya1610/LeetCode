class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        long res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && arr[i]<arr[s.peek()]) {
                s.pop();
            }
            left[i] = s.isEmpty()? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--) {
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        for(int i=0;i<n;i++) {
            res = (res + (long) arr[i]*(i-left[i])*(right[i]-i)%MOD)%MOD;
        }
        return (int)res;
    }
}