class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] d = new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
            d[i][i] = 0;
        }
        for(int[] e:edges) {
            int f = e[0];
            int t = e[1];
            int w = e[2];
            d[f][t] = w;
            d[t][f] = w;
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(d[i][k]!=Integer.MAX_VALUE&&d[k][j]!=Integer.MAX_VALUE) {
                        d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int city = -1;
        for(int i=0;i<n;i++) {
            int c = 0;
            for(int j=0;j<n;j++) {
                if(i!=j&&d[i][j]<=distanceThreshold) {
                    c++;
                }
            }
            if(c<=min) {
                min = c;
                city = i;
            }
        }
        return city;
    }
}