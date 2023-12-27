class Solution {
    public int minCost(String colors, int[] neededTime) {
        int c=0;
        int n=colors.length();
        int sum=neededTime[0];
        int max=neededTime[0];
        for(int i=1;i<n;i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                sum+=neededTime[i];
                max=Math.max(max,neededTime[i]);
            }
            else {
                c+=sum-max;
                sum=neededTime[i];
                max=neededTime[i];
            }
        }
        c+=sum-max;
        return c;
    }
}