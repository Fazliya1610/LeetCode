class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] res = new int[queries.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        for(int[] q:queries) {
            int x = q[0];
            int y = q[1];
            if(map.containsKey(x)) {
                int old = map.get(x);
                col.put(old, col.get(old)-1);
                if(col.get(old)==0) {
                    col.remove(old);
                }
            }
            map.put(x, y);
            col.put(y, col.getOrDefault(y, 0)+1);
            res[index++] = col.size();
        }
        return res;
    }
}