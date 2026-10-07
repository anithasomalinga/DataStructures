package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class AllCombinations1 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        List<List<Integer>> allCombos = getAllCombinations(arr);
        System.out.println(allCombos);
    }

    private static List<List<Integer>> getAllCombinations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backTrack(int[] arr, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // create a new list containing curr values; later if current changes result is not impacted
        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            // move to the next element
            backTrack(arr, i + 1, current, result);
            // backtrack
            current.removeLast();
        }
    }
}
