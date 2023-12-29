class Solution {
    public int countCharacters(String[] words, String chars) {
        char[] c=chars.toCharArray();
        int sum=0;
        int n=c.length;
        for(int i=0;i<words.length;i++){
            int j=0,k=0;
            int len=words[i].length();
            char[] ch=words[i].toCharArray();
            Arrays.sort(c);
            Arrays.sort(ch);
            while(j<n&&k<len){
                if(c[j]==ch[k]){
                    j++;
                    k++;
                }
                else{
                    j++;
                }
            }
            if(k==len){
                sum+=len;
            }
        }
        return sum;
    }
}