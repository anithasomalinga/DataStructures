package leetcode;

public class StrToInt {
    public static void main(String[] args) {

    }

    public static int myAtoi(String s) {
        int i = 0; int n = s.length();
        // skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        // check for sign
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        // convert digits to integer
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return sign * result;
    }
}
