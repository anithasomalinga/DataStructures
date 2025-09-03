package leetcode.greedyalgorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public static void main(String[] args) {
        String roman = "XII";
        int integer = 801;
        int intResult = romanToInteger(roman);
        System.out.printf("Roman to Integer : %s -> %s \n", roman, intResult);
        int intRes = romanToInteger(roman);
        System.out.printf("Roman to Integer : %s -> %s \n", roman, intRes);
        String strResult = integerToRoman(integer);
        System.out.printf("Integer to Roman : %s -> %s \n", integer, strResult);
//        integer = 800;
        String result = intToRoman(integer);
        System.out.printf("Integer to Roman : %s -> %s \n", integer, result);
        String strResult1 = integerToRoman1(integer);
        System.out.printf("Integer to Roman : %s -> %s \n", integer, strResult1);
    }

    private static int romanToInteger(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanMap.get(s.charAt(i));
            // Check for subtractive cases
            if (i < s.length() - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
        }
        return total;
    }

    private static String integerToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    private static String integerToRoman1(int num) {
        String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};
        int[] values = {1000, 500, 100, 50, 10, 5, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    private static String intToRoman(int num) {
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i=0; i<values.length;i++){
            while (num >= values[i]){
                result.append(romans[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    private static int romanToInt(String str){
        Map<Character,Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        char[] chars = str.toCharArray();
        int total = 0;
        for(int i=0;i<chars.length;i++){
            int currVal = map.get(chars[i]);
            if(i < chars.length -1 && currVal < map.get(chars[i + 1])) {
                total -= map.get(chars[i]);
            } else
                total += map.get(chars[i]);
        }
        return total;
    }
}
