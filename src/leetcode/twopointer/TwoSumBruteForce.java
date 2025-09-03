package leetcode.twopointer;

import java.util.Arrays;

// Time Complexity is O(n^2) - every element of array compares with every other element
// Space complexity - O(1)
public class TwoSumBruteForce {
    public static void main(String[] args) {
        int[] array = new int[] {4,3,9};
        int target = 13;
        int[] result = twoIndeces(array, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] twoIndeces(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
