package leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[] {9,8,7,6,5,4,3,2,1,0};
        plusOne(digits);
    }

    // SOLUTION ONLY WORKS FOR INTEGER RANGE
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
//        int[] result = new int[digits[i] == 9 ? n + 1 : n];
        String numStr = "";
        for(int i=0;i<n;i++){
            numStr += digits[i];
        }
        String plusOne = String.valueOf(Integer.parseInt(numStr) + 1);
        System.out.println(plusOne);
        int[] result = plusOne.chars().map(Character::getNumericValue).toArray();
        System.out.println(Arrays.toString(result));
        return result;
    }

    public int[] plusOneEfficient(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i>=0;i--){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
