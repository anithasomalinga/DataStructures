package hackerrank.ibm;

import java.math.MathContext;
import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Is valid: " + isValidUserName(name));
    }
    public static boolean isValidUserNameRegularExpression(String name) {
//        if (name == null || name.length() < 8 || name.length() > 30) return false;
        String regularExpression = "^[a-zA-Z][0-9a-zA-Z_]{7,29}$";
        return name.matches(regularExpression);
    }

    public static boolean isValidUserName(String name) {
        if (name == null || name.length() < 8 || name.length() > 30) return false;
        if (!Character.isLetter(name.charAt(0))) return false; // takes unicode letters and digits as well. use ASCII method if otherwise
        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') return false;
        }
        return true;
    }

    private static boolean isAsciiLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isAsciiDigit(char c) {
        return (c >= '0' && c <= '9');
    }
}
