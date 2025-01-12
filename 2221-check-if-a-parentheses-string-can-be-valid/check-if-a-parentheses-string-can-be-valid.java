class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2==1) {
            return false;
        }
        int min = 0, max = 0;
        for(int i=0;i<n;i++) {
            if(locked.charAt(i)=='1') {
                if(s.charAt(i)=='(') {
                    min++;
                    max++;
                }
                else {
                    min--;
                    max--;
                }
            }
            else {
                min--;
                max++;
            }
            if(min<0) {
                min = 0;
            }
            if(max<0) {
                return false;
            }
        }
        if(min!=0) {
            return false;
        }
        min = 0;
        max = 0;
        for(int i=n-1;i>=0;i--) {
            if(locked.charAt(i)=='1') {
                if(s.charAt(i)=='(') {
                    min--;
                    max--;
                }
                else {
                    min++;
                    max++;
                }
            }
            else {
                min--;
                max++;
            }
            if(min<0) {
                min = 0;
            }
            if(max<0) {
                return false;
            }
        }
        return true;
    }
}