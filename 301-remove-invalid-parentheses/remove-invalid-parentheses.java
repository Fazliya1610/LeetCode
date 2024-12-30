class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        vis.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String curr = q.poll();
                if(isValid(curr)) {
                    res.add(curr);
                    found = true;
                }
                if(found) {
                    continue;
                }
                for(int j=0;j<curr.length();j++) {
                    if(curr.charAt(j)!='('&&curr.charAt(j)!=')') {
                        continue;
                    }
                    String next = curr.substring(0, j)+curr.substring(j+1);
                    if(!vis.contains(next)) {
                        q.add(next);
                        vis.add(next);
                    }
                }
            }
            if(found) {
                break;
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for(char c:s.toCharArray()) {
            if(c=='(') count++;
            else if(c==')') count--;
            if(count<0)
            return false;
        }
        return count==0;
    }
    
}