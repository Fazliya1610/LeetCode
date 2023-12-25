class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] d=new int[n+1];
        d[0]=1;
        d[1]=s.charAt(0)!='0'?1:0;
        for(int i=2;i<=n;i++){
            int o=Integer.parseInt(s.substring(i-1,i));
            int t=Integer.parseInt(s.substring(i-2,i));
            if(o>=1&&o<=9){
                d[i]+=d[i-1];
            }
            if(t>=10&&t<=26){
                d[i]+=d[i-2];
            }
        }
        return d[n];
    }
}