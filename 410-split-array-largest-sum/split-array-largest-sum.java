class Solution {
    
    public int countPartitions(int[] a, int n,int maxSum) {
        int partition = 1;
        int sum = 0;
        for(int i=0;i<n;i++) {
            if(sum+a[i]<=maxSum) {
                sum+=a[i];
            }
            else {
                partition++;
                sum = a[i];
            }
        }
        return partition;
    }

    public int splitArray(int[] a, int k) {
        int n = a.length;
        int low = a[0];
        int high = 0;
        for(int i=0;i<n;i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }
        while(low<=high) {
            int mid = (low+high)/2;
            int partition = countPartitions(a, n, mid);
            if(partition>k) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
}