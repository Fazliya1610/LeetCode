class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()) {
            if(c!=')') {
                st.push(c);
            }
            else {
                String k = "";
                while(!st.isEmpty()&&st.peek()!='(') {
                    k+=st.pop();
                }
                if(!st.isEmpty()&&st.peek()=='(') {
                    st.pop();
                }
                for(char ch:k.toCharArray()) {
                    st.push(ch);
                }
            }
        }
        String res = "";
        for(char c:st) {
            res+=c;
        }
        return res;
    }
}