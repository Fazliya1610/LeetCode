class Solution {
    public String decodeString(String s) {
        Stack<Integer> dig = new Stack<>();
        int num = 0;
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()) {
            if(ch>='0'&&ch<='9') {
                num = num*10 + Character.getNumericValue(ch);
            }
            else if(ch=='[') {
                dig.push(num);
                num = 0;
                stack.push(sb);
                sb = new StringBuilder();
            }
            else if(ch==']') {
                StringBuilder rep = sb;
                int rc = dig.pop();
                sb = stack.pop();
                while(rc-- > 0) {
                    sb.append(rep);
                }
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}