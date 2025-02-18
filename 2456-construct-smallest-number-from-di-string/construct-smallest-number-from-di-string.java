class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = pattern.length();
        for(int i=0;i<n;i++) {
            st.push(i+1);
            if(pattern.charAt(i)=='I') {
                while(!st.isEmpty()) {
                    res.append(st.pop());
                }
            }
        }
        st.push(n+1);
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }
}