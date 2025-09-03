package leetcode.greedyalgorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals1 {
    public static void main(String[] args) {
        // I-1, V-5, X-10, L-50, C-100, D-500, M-1000
        // Roman to Integer
        String romanStr = "XIV";
        int result = romanToInteger(romanStr);
        System.out.println(result);

        // Integer to Roman
        int num = 14;
        String numeral = integerToRoman(num);
        System.out.println(numeral);
    }

    private static int romanToInteger(String str) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            char  c = str.charAt(i);
            int num = romanMap.get(c);
            if(i < str.length()-1 && romanMap.get(c) < romanMap.get(str.charAt(i+1))){
                total -= num;
            } else {
                total += num;
            }
        }
        return total;
    }

    private static String integerToRoman(int num) {
        String[] characters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] charNums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < characters.length; i++){
            while(num >= charNums[i]){
                sb.append(characters[i]);
                num -= charNums[i];
            }
        }
return sb.toString();
    }
}
