package leetcode.twopointer;

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
        for (int i = 0; i < str.length(); i++) {
            while (i < j) {
                if (str.charAt(i) == str.charAt(j)) {
                    i++;
                    j--;
                } else
                    return false;
            }
        }
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

}
