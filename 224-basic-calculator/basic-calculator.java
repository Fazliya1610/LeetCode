class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int curr = 0, sym = 1, res = 0;
        for(char c:s.toCharArray()) {
            if(Character.isDigit(c)) {
                int dig = c-'0';
                curr = (curr*10)+dig;
            }
            else if(c=='+'||c=='-') {
                res+=curr*sym;
                curr = 0;
                if(c=='+') {
                    sym = 1;
                }
                else {
                    sym = -1;
                }
            }
            else if(c=='(') {
                st.push(res);
                st.push(sym);
                res = 0;
                sym = 1;
            }
            else if(c==')') {
                res+=curr*sym;
                res*=st.pop();
                res+=st.pop();
                curr = 0;
            }
        }
        return res+curr*sym;
    }
}