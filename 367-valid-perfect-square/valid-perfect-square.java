class Solution {
    public boolean isPerfectSquare(int num) {
        double d = Math.sqrt(num);
        int q = (int)d;
        return d==(double)q;
    }
}