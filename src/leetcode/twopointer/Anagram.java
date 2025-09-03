package leetcode.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Not 2 pointer
public class Anagram {
    public static void main(String[] args) {
        boolean result = isAnagram("great", "trgea");
        System.out.println(result ? "Is anagram" : "Not an anagram");
    }

    private static boolean isAnagram(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }
}
