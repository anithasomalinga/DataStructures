package hackerrank.ibm;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public static void main(String[] args) {
        int num = 801;
        String roman = "XII";

        int r1 = romanToInt(roman);
        String r2 = integerToRoman(num);

        System.out.println("Roman to Int -> " + roman + " -> " + r1);
        System.out.println("Int to Roman -> " + num + " -> " + r2);
    }

    private static int romanToInt(String roman) {
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
            int currValue = map.get(roman.charAt(i));
            if (i < roman.length() - 1 && currValue < map.get(roman.charAt(i + 1))) {
                total -= currValue;
            } else {
                total += currValue;
            }
        }
        return total;
    }

    private static String integerToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                builder.append(romans[i]);
                num -= values[i];
            }
        }
        return builder.toString();
    }
}
