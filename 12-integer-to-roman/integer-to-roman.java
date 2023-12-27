class Solution {
    public String intToRoman(int num) {
        String[] s={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] v={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder res=new StringBuilder();
        for(int i=0;i<v.length;i++){
            while(num>=v[i]){
                res.append(s[i]);
                num-=v[i];
            }
        }
        return res.toString();
    }
}