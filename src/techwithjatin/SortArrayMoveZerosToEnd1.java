package techwithjatin;

import java.util.Arrays;

public class SortArrayMoveZerosToEnd1 {
    public static void main(String[] args) {
        int[] input = {1, 3, 0, 4, 5, 0, 2, 0};
        int j = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] != 0) {
                int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                j++;
            }
        }
        Arrays.sort(input, 0, j);
        System.out.println(Arrays.toString(input));
    }
}
