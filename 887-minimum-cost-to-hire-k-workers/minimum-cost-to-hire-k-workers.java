class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double tot = Double.MAX_VALUE;
        double curr = 0;
        List<Pair<Double, Integer>> w = new ArrayList<>();
        for(int i=0;i<n;i++) {
            w.add(new Pair<>((double)wage[i]/quality[i], quality[i]));
        }
        Collections.sort(w, Comparator.comparingDouble(Pair::getKey));
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) {
            p.add(w.get(i).getValue());
            curr+=w.get(i).getValue();
            if(p.size()>k) {
                curr-=p.poll();
            }
            if(p.size()==k) {
                tot = Math.min(tot, curr*w.get(i).getKey());
            }
        }
        return tot;
    }
}