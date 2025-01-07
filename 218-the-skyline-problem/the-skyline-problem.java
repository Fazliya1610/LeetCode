class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
		List<int[]> height = new ArrayList<>();
		for(int[] b:buildings) {
		    height.add(new int[]{b[0], -b[2]});
		    height.add(new int[]{b[1], b[2]});
		}
		Collections.sort(height, (a, b) -> {
		    if(a[0]!=b[0]) {
		        return a[0]-b[0];
		    }
		    return a[1]-b[1];
		});
		TreeMap<Integer, Integer> pq = new TreeMap<>();
		pq.put(0, 1);
		int prev = 0;
		for(int[] h:height) {
		    int x = h[0];
		    int k = h[1];
		    if(k<0) {
		        pq.put(-k, pq.getOrDefault(-k, 0)+1);
		    }
		    else {
		        if(pq.get(k)==1) {
		            pq.remove(k);
		        }
		        else {
		            pq.put(k, pq.get(k)-1);
		        }
		    }
		    int curr = pq.lastKey();
		    if(prev!=curr) {
		        res.add(Arrays.asList(x, curr));
		        prev = curr;
		    }
		}
        return res;
    }
}