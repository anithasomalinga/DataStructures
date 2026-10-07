package leetcode.twopointer;

import java.util.Scanner;

public class Anagram2 {
    public static void main(String[] args) {
        System.out.println("Enter 2 strings");
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        boolean iaAna = isAnagram(str[0], str[1]);
        System.out.println(iaAna);
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) return false;
        int[] ascii = new int[123];
        for(int i = 0; i < s1.length(); i++) {
            ascii[s1.charAt(i)]++;
            ascii[s2.charAt(i)]--;
        }
        for (int j : ascii) {
            if (j != 0) return false;
        }
        return true;
    }
}
