package leetcode.greedyalgorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals2 {
    public static void main(String[] args) {
        String roman = "XII";
        int numeral = 801;
        int romanToNumeral = romanToNumeral(roman);
        System.out.println("Roman: " + roman + " Numeral: " + romanToNumeral);
        String numeralToRoman = numeralToRoman(numeral);
        System.out.println("Numeral: " + numeral + " Roman: " + numeralToRoman);
    }

    private static int romanToNumeral(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;
        for (int i = 0; i < roman.length(); i++) {
            int curr = map.get(roman.charAt(i));
            if (i < roman.length() - 1 && curr < map.get(roman.charAt(i + 1))) {
                total -= curr;
            } else {
                total += curr;
            }
        }
        return total;
    }

    private static String numeralToRoman(int numeral) {
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numerals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numerals.length; i++) {
            while (numeral >= numerals[i]) {
                sb.append(romans[i]);
                numeral -= numerals[i];
            }
        }
        return sb.toString();
    }
}
