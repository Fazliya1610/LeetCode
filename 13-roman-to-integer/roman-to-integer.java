import java.util.*;
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> r=new HashMap<>();
        r.put('I',1);
        r.put('V',5);
        r.put('X',10);
        r.put('L',50);
        r.put('C',100);
        r.put('D',500);
        r.put('M',1000);
        int res=0;
        int p=0;
        for(int i=s.length()-1;i>=0;i--) {
            char c=s.charAt(i);
            int v=r.get(c);
            if(v<p) {
                res-=v;
            }
            else {
                res+=v;
            }
            p=v;
        }
        return res;
    }
}