package leetcode.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Time Complexity is O(n) - iterate through the array once
// Hashmap - insert and lookup - O(1)
// Space complexity = O(n)
public class TwoSumBestSolution {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4};
        int target = 6;
        int[] result = twoIndeces(array, target);
        System.out.println("Indices of two values that add up to the target: " + Arrays.toString(result));

        int[] result1 = twoIndices(array, target);
        System.out.println("Indices of two values that add up to the target: " + Arrays.toString(result1));

        int[] result2 = twoNumbersInArray(array, target);
        System.out.println("Two values that add up to the target: " + Arrays.toString(result2));
    }

    private static int[] twoIndeces(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(target - array[i], i);
            } else {
                return new int[]{i, map.get(array[i])};
            }
        }
        return null;
    }

    // returns the numbers in array that sum up to the target
    private static int[] twoNumbersInArray(int[] array, int target) {
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == target) {
                return new int[]{array[i], array[j]};
            } else if (array[i] + array[j] > target) {
                j--;
            } else i++;
        }
        return null;
    }

    private static int[] twoIndices(int[] array, int target) {
        Map<Integer, Integer> differenceToTarget = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!differenceToTarget.containsKey(array[i])) {
                differenceToTarget.put(target - array[i], i);
            } else {
                return new int[]{i, differenceToTarget.get(array[i])};
            }
        }
        return null;
    }

}
