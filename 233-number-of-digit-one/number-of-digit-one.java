class Solution {
    public int countDigitOne(int n) {
        int c = 0;
        long f = 1;
        while(n/f>0) {
            long l = n%f;
            long curr = (n/f)%10;
            long h = n/(f*10);
            c+=h*f;
            if(curr==1) {
                c+=l+1;
            }
            else if(curr>1) {
                c+=f;
            }
            f*=10;
        }
        return c;
    }
}