class Solution {
    public int myAtoi(String s) {
        long num = 0;
        boolean f = false;
        boolean sign = false;
        boolean neg = false;
        boolean l = false;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c>='0'&&c<='9') {
                num = num*10+Character.getNumericValue(c);
                l = true;
                if(num<-(long)Math.pow(2, 31)||num>(long)Math.pow(2, 31)-1) {
                    if(neg)
                    return -2147483648;
                    else 
                    return 2147483647;
                }
            }
            else if((c=='-'||c=='+')&&(i=='0'||!l)&&!sign) {
                if(c=='-') {
                    neg = true;
                }
                sign = true;
            }
            else if((c==' '||c=='\t')&&!l&&!sign) {
                continue;
            }
            else {
                break;
            }
        }
        if(neg) {
            num = num*(long)(-1);
        }
        int res = 0;
        if(num<-(long)Math.pow(2, 31)||num>(long)Math.pow(2, 31)-1) {
            if(neg)
            return -2147483648;
            else 
            return 2147483647;
        }
        else {
            res = (int)num;
        }
        return res;
    }
}