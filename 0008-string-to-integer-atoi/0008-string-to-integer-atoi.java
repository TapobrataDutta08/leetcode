public class Solution {
    public static void main(String[] args) {
        Solution solver = new Solution();
        String testStr = "  -42";
        System.out.println("Converted integer for \"" + testStr + "\": " + solver.myAtoi(testStr));
    }

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int i = 0;
        int n = s.length();
        
        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == n) return 0;
        
        // 2. Check sign
        int sign = 1;
        char firstChar = s.charAt(i);
        if (firstChar == '-') {
            sign = -1;
            i++;
        } else if (firstChar == '+') {
            i++;
        }
        
        // 3. Convert digits and handle clamping
        long result = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            
            result = result * 10 + (c - '0');
            
            // 4. Check for overflow and clamp
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        return (int) (result * sign);
    }
}