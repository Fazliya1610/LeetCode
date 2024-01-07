class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int total=0;
        Map<Long, Integer>[] hm=new HashMap[n];
        for(int i=0;i<n;i++) {
            hm[i]=new HashMap<>();
        }
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                long diff=(long)nums[i]-nums[j];
                int cdiff=hm[j].getOrDefault(diff,0);
                total+=cdiff;
                hm[i].put(diff,hm[i].getOrDefault(diff,0)+cdiff+1);
            }
        }
        return total;
    }
}