class Solution {
    public boolean isPowerOfThree(int n) {
        int i = 0;
        if(n<=0) {
            return false;
        }
        /*if(n<0) {
            n*=(-1);
        }*/
        while(true) {
            long k = (long)Math.pow(3, i);
            if(k==n) {
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