package hackerrank.ibm;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i = 0, j = str.length() - 1;
        boolean isPalindrome = true;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
