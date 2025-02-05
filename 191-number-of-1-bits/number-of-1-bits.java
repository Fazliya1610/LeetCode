class Solution {
    public int hammingWeight(int n) {
        String bin = Integer.toBinaryString(n);
        return count(bin);
    }
    private int count(String bin) {
        int c = 0;
        for(char ch:bin.toCharArray()) {
            if(ch=='1') {
                c++;
            }
        }
        return c;
    }
}