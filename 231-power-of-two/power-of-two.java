class Solution {
    public boolean isPowerOfTwo(int n) {
        int i = 0;
        while(true) {
            long k = (long)Math.pow(2, i);
            if(k==(long)n) {
                return true;
            }
            else if(k>n) {
                break;
            }
            i++;
        }
        return false;
    }
}