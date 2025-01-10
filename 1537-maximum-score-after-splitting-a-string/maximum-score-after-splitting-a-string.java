class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int max = 0;
        for(int i=1;i<n;i++) {
            int left = score(s.substring(0, i), true);
            int right = score(s.substring(i, n), false);
            max = Math.max(max, left+right);
        }
        return max;
    }

    private int score(String s, boolean b) {
        int count = 0;
        for(char c:s.toCharArray()) {
            if(c=='0'&&b) {
                count++;
            }
            if(c=='1'&&!b) {
                count++;
            }
        }
        return count;
    }
}