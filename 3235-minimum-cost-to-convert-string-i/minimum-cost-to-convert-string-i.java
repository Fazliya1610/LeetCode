class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int inf = Integer.MAX_VALUE/2;
        long[][] d = new long[26][26];
        for(long[] r:d) {
            Arrays.fill(r, inf);
        }
        for(int i=0;i<original.length;i++) {
            int u = original[i]-'a';
            int v = changed[i]-'a';
            d[u][v] = Math.min(d[u][v], cost[i]);
        }
        for(int i=0;i<26;i++) {
            d[i][i] = 0;
        }
        for(int k=0;k<26;k++) {
            for(int i=0;i<26;i++) {
                for(int j=0;j<26;j++) {
                    if(d[i][k]<inf&&d[k][j]<inf) {
                        d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
                    }
                }
            }
        }
        long tot = 0;
        for(int i=0;i<n;i++) {
            int s = source.charAt(i)-'a';
            int t = target.charAt(i)-'a';
            if(d[s][t]==inf) {
                return -1;
            }
            tot+=d[s][t];
        }
        return tot;
    }
}