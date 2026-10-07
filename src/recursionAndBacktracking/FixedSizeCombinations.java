package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeCombinations {

    // Total valid combinations n, k - n!/k!(n-k)!
    // Time Complexity - O(k * totalValidCombo)
    // Space Complexity = O(k)
    public static List<List<Integer>> getCombinations(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || k < 0 || k > arr.length) return result;

        backtrack(arr, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int k, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination is complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Loop through the remaining elements
        for (int i = start; i < arr.length; i++) {
            // Include the element
            current.add(arr[i]);

            // Recurse with the next index
            backtrack(arr, k, i + 1, current, result);

            // Backtrack (remove the last element)
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int k = 2;
        List<List<Integer>> combinations = getCombinations(input, k);

        System.out.println("Combinations of size " + k + ":");
        System.out.println(combinations);
    }
}
