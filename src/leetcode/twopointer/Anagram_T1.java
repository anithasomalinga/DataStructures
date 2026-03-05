package leetcode.twopointer;

import java.util.stream.IntStream;

public class Anagram_T1 {
    public static void main(String[] args) {
        String word1 = "mac";
        String word2 = "acr";
        boolean isAnagram = isAnagram(word1, word2);
        System.out.println("Is Anagram ? " + isAnagram);

    }

    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] chars = new int[256];
        int n = word1.length();
        IntStream.range(0, n).forEach(i -> {
            chars[word1.charAt(i)]++;
            chars[word2.charAt(i)]--;
        });
        return IntStream.range(0, 256).noneMatch(i -> chars[i] > 0);
    }

}
