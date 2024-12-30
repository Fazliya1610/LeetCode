class Solution {
    public boolean isPowerOfFour(int n) {
        for(int i=0;i<Math.sqrt(n);i++) {
            if(Math.pow(4, i)==n) {
                return true;
            }
            if(Math.pow(4, i)>n) {
                return false;
            }
        }
        return false;
    }
}