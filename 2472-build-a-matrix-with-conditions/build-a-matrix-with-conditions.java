class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] m = new int[k][k];
        int[] row = topo(k, rowConditions);
        int[] col = topo(k, colConditions);
        if(row.length==0||col.length==0) {
            return new int[0][0];
        }
        int[] r = new int[k+1];
        int[] c = new int[k+1];
        for(int i=0;i<k;i++) {
            r[row[i]] = i;
            c[col[i]] = i;
        }
        for(int i=1;i<=k;i++) {
            m[r[i]][c[i]] = i;
        }
        return m;
    }

    private int[] topo(int k, int[][] con) {
        int[] in = new int[k+1];
        List<Integer>[] g = new ArrayList[k+1];
        for(int i=1;i<=k;i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] c:con) {
            int u = c[0];
            int v = c[1];
            g[u].add(v);
            in[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=k;i++) {
            if(in[i]==0) {
                q.offer(i);
            }
        }
        int[] o = new int[k];
        int index = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            o[index++] = u;
            for(int v:g[u]) {
                in[v]--;
                if(in[v]==0) {
                    q.offer(v);
                }
            }
        }
        return index==k?o: new int[0];
    }
}