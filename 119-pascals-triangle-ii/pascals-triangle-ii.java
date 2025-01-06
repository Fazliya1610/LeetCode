class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++) {
            l.add((int)nCr(rowIndex, i));
        }
        return l;
    }

    private long nCr(int n, int r) {
        long res = 1;
        for(int i=0;i<r;i++) {
            res *= (n-i);
            res /= (i+1);
        }
        return res;
    }
}