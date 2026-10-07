package leetcode.twopointer;

import java.util.Scanner;

public class Anagram1 {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            String first = input.next().trim();
            if(first.equals("exit")) break;
            String second = input.next().trim();
            boolean isAnagram = isAnagram(first, second);
            System.out.println("Is Anagram? " + isAnagram);
        }
    }

    // not 2 pointer!!!!!
    public static boolean isAnagram(String first, String second) {
        if (first.isEmpty() || second.isEmpty()) {
            return false;
        } else if(first.length() != second.length()) {
            return false;
        } else {
            int[] chars = new int[256]; // ASCII / UNICODE char range. 'A' is 65. 'a' is 97
            for (int i = 0; i< first.length(); i++) {
                chars[first.charAt(i)]++; // By default Java converts char to its ascii/unicode int value
                chars[second.charAt(i)]--;
            }
            for(int i = 0; i < 256; i++) {
                if(chars[i] > 0) return false;
            }
        }
        return true;
    }
}
