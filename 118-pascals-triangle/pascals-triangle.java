class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pas = new ArrayList<>();
        for(int row=1;row<=numRows;row++) {
            pas.add(getRow(row));
        }
        return pas;
    }
    private List<Integer> getRow(int row) {
        List<Integer> l = new ArrayList<>();
        long res = 1;
        l.add((int)res);
        for(int i=1;i<row;i++) {
            res*=(row-i);
            res/=i;
            l.add((int)res);
        }
        return l;
    }
}