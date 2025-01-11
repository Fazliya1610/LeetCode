class Solution {
    public String getPermutation(int n, int k) {
        int f = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n;i++) {
            f*=i;
            list.add(i);
        }
        list.add(n);
        k--;
        StringBuilder res = new StringBuilder();
        while(true) {
            res.append(list.get(k/f));
            list.remove(k/f);
            if(list.size()==0) {
                break;
            }
            k%=f;
            f/=list.size();
        }
        return res.toString();
    }
}