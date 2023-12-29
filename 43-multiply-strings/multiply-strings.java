import java.math.BigDecimal;
class Solution {
    public String multiply(String num1, String num2) {
        BigDecimal a = new BigDecimal(num1);
        BigDecimal b = new BigDecimal(num2);
        return a.multiply(b).toString();
    }
}