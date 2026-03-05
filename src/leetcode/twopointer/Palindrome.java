package leetcode.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean result = isPalindrome(scanner.nextLine());
        System.out.println(result ? "Is palindrome" : "Not a palindrome");
        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        int j = str.length() - 1;
        int i = 0;
//        for (int i = 0; i < str.length(); i++) {
            while (i < j) {
                if (str.charAt(i) == str.charAt(j)) {
                    i++;
                    j--;
                } else
                    return false;
            }
//        }
        return true;
    }

    private static boolean isPalindromeTwoPointer(String str) {
        char[] characters = str.toCharArray();
        int i = 0;
        int j = characters.length - 1;
        while (i <= j) {
            if (characters[i] == characters[j]) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    // better solution
    /*
    ✅ Space: O(1)

No new strings created
Works directly on original string

✅ Time: O(n) but faster

Single pass through string
Character.isLetterOrDigit() is faster than regex
Early exit on first mismatch

✅ Cleaner Logic:

Skip invalid characters on-the-fly
Compare as you go
*/
    public boolean isPalindromeBest(String s) {
        int i = 0; int j = s.length() - 1;
        while (i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
