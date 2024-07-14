class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> c = parseFormula(formula);
        return format(c);
    }

    private Map<String, Integer> parseFormula(String formula) {
        Deque<Map<String, Integer>> s = new ArrayDeque<>();
        s.push(new HashMap<>());
        int n = formula.length();
        for(int i=0;i<n;) {
            char c = formula.charAt(i);
            if(c=='(') {
                s.push(new HashMap<>());
                i++;
            }
            else if(c==')') {
                Map<String, Integer> t = s.pop();
                int is = ++i;
                while(i<n&&Character.isDigit(formula.charAt(i))) i++;
                int mul = is<i?Integer.parseInt(formula.substring(is, i)):1;
                for(String name:t.keySet()) {
                    int count = t.get(name);
                    s.peek().put(name, s.peek().getOrDefault(name, 0)+count*mul);
                }
            }
            else {
                int is = i++;
                while(i<n&&Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(is, i);
                is = i;
                while(i<n&&Character.isDigit(formula.charAt(i))) i++;
                int mul = is<i? Integer.parseInt(formula.substring(is, i)):1;
                s.peek().put(name, s.peek().getOrDefault(name, 0)+mul);
            }
        }
        return s.pop();
    }

    private String format(Map<String, Integer> c) {
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> s = new TreeMap<>(c);
        for(String e: s.keySet()) {
            sb.append(e);
            int count = s.get(e);
            if(count>1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
}