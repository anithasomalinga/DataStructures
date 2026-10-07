package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class AllCombinations {

    // Time Complexity - O(n * 2^n)
    // Space Complexity = O(n)
    public static List<List<Integer>> getAllSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null) return result;

        backtrack(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int start, List<Integer> current, List<List<Integer>> result) {
        // Every state in the recursion tree represents a valid subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);

            // Move to the next element
            backtrack(arr, i + 1, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<List<Integer>> allSubsets = getAllSubsets(input);

        System.out.println("All possible subsets:");
        System.out.println(allSubsets);
    }
}

