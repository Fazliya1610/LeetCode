class Solution {
    public int reverse(int x) {
        String s=Integer.toString(x);
        boolean N=false;
        if(x<0){
            N=true;
            s=s.substring(1);
        }
        StringBuilder rev=new StringBuilder(s).reverse();
        try{
            int r=Integer.parseInt(rev.toString());
            return N?-r:r;
        }
        catch(NumberFormatException e){
            return 0;
        }
    }
}