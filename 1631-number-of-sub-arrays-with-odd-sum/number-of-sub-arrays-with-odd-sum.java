class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int n = arr.length, c = 0, res = 0;
        boolean odd = false;
        for(int i=0;i<n;i++) {
            if(arr[i]%2==1) {
                odd = !odd;
            }
            if(odd) {
                c++;
            }
        }
        for(int i=0;i<n;i++) {
            res+=c;
            if(arr[i]%2==1) {
                c = (n-i-c);
            }
            res%=mod;
        }
        return res;
    }
}