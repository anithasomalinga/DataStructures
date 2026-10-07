package techwithjatin;

import java.util.Arrays;

public class SortArrayMoveZerosToEnd {
    // 1 3 0 4 5 0 2 0
    // Op should be 1,2,3,4,5,0,0,0 zeros moved to the end and numbers printed separated by commas
    public static void main(String[] args) {
        int[] input = {1,3,0,4,5,0,2,0};
        int index = 0;
        System.out.println(Arrays.toString(input));
        // All non-zero numbers are updated first
        for (int num : input) {
            if (num != 0) {
                input[index] = num;
                index++;
            }
        }
        System.out.println(Arrays.toString(input));
        System.out.println("Index: " + index);
        // add zeros from index till end of array
        for (int i = index; i < input.length; i++) {
            input[i] = 0;
        }
        // Sort the array
        Arrays.sort(input, 0, index);
        System.out.println(Arrays.toString(input));
    }
}
