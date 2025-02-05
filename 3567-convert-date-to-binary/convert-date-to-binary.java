class Solution {
    public String convertDateToBinary(String date) {
        String[] d = date.split("-");
        StringBuilder res = new StringBuilder();
        res.append(Integer.toBinaryString(Integer.parseInt(d[0])));
        res.append("-");
        res.append(Integer.toBinaryString(Integer.parseInt(d[1])));
        res.append("-");
        res.append(Integer.toBinaryString(Integer.parseInt(d[2])));
        return res.toString();
    }
}