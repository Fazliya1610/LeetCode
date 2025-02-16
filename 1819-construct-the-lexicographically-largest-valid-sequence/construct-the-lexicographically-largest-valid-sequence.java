class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n-1];
        boolean[] use = new boolean[n+1];
        backtrack(res, use, n, 0);
        return res;
    }

    private boolean backtrack(int[] res, boolean[] use, int n, int index) {
        while(index<res.length&&res[index]!=0) {
            index++;
        }
        if(index==res.length) {
            return true;
        }
        for(int i=n;i>=1;i--) {
            if(use[i]) {
                continue;
            }
            if(i==1) {
                res[index] = 1;
                use[1] = true;
                if(backtrack(res, use, n, index+1)) {
                    return true;
                }
                res[index] = 0;
                use[1] = false;
            }
            else {
                if(index+i<res.length&&res[index+i]==0) {
                    res[index] = i;
                    res[index+i] = i;
                    use[i] = true;
                    if(backtrack(res, use, n, index+1)) {
                        return true;
                    }
                    res[index] = 0;
                    res[index+i] = 0;
                    use[i] = false;
                }
            }
        }
        return false;
    }
}