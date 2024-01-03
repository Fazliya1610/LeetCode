class Solution {
    public int numberOfBeams(String[] bank) {
        int i = 0;
        int num = 0;
        int l = 1;
        while(i<bank.length&&i+l<bank.length) {
            int a = 0;
            for(int j=0;j<bank[i].length();j++) {
                if(bank[i].charAt(j)=='1') {
                    a++;
                }
            }
            int k = i+l;
            int b = 0;
            for(int j=0;j<bank[k].length();j++) {
                if(bank[k].charAt(j)=='1') {
                    b++;
                }
            }
            if(b!=0) {
                l = 1;
                i++;
                num+=(a*b);
            }
            else {
                l++;
            }

        }
        return num;
    }
}