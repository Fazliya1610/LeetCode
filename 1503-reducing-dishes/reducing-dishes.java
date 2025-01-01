class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        int curr = 0;
        for(int i=satisfaction.length-1;i>=0;i--) {
            if(curr+satisfaction[i]>0) {
                curr+=satisfaction[i];
                max+=curr;
            }
            else {
                break;
            }
        }
        return max;
    }
}