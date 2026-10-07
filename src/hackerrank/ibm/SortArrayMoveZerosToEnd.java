package hackerrank.ibm;

import java.util.Arrays;

public class SortArrayMoveZerosToEnd {
    // 1 3 0 4 5 0 2 0
    // Op should be 1,2,3,4,5,0,0,0 zeros moved to the end and numbers printed separated by commas
    public static void main(String[] args) {
        int[] input = {1,3,0,4,5,0,2,0};
        int j = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                j++;
            }
        }
        for (int i = j; i < input.length; i++) {
            input[i] = 0;
        }
        Arrays.sort(input, 0, j);
        System.out.println(Arrays.toString(input));
    }
}
