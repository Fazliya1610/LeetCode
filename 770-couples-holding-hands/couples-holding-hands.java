class Solution {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        int n = row.length;
        for(int i=0;i<n;i++) {
            pos.put(row[i], i);
        }
        int swaps = 0;
        for(int i=0;i<n;i+=2) {
            int first = row[i];
            int second = first^1;
            if(second!=row[i+1]) {
                swaps++;
                int part = pos.get(second);
                int t = row[i+1];
                row[i+1] = second;
                row[part] = t;
                pos.put(t, part);
                pos.put(second, i+1);
            }
        }
        return swaps;
    }
}