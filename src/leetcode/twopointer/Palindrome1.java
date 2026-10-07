package leetcode.twopointer;

import java.util.Scanner;

public class Palindrome1 {
    public static void main(String[] args) {
        while(true) {
            Scanner input = new Scanner(System.in);
            String word = input.next().trim();
            if(word.equals("exit")) break;
            boolean isPalindrome = isPalindrome(word);
            System.out.println("Is Palindrome? " + isPalindrome);
        }
    }
    public static boolean isPalindrome(String word) {
        if(word.isEmpty()) return false;
        else {
            int i = 0, j = word.length() - 1;
            while (i <= j) {
                if (word.charAt(i) == word.charAt(j)) {
                    i++;
                    j--;
                } else return false;
            }
        }
        return true;
    }
}
