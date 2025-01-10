class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        int[] dp = new int[words.length+1];
        for(int i=0;i<words.length;i++) {
            if("aeiou".indexOf(words[i].charAt(0))>=0&&"aeiou".indexOf(words[i].charAt(words[i].length()-1))>=0) {
                dp[i+1] = dp[i]+1;
            }
            else {
                dp[i+1] = dp[i];
            }
        }
        int index = 0;
        for(int[] q:queries) {
            int l = q[0], r = q[1];
            res[index] = dp[r+1]-dp[l];
            index++;
        }
        return res;
    }
}