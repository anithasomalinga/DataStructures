package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeCombinations1 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        int k = 2;
        List<List<Integer>> combos = kSizedCombos(arr, k);
        System.out.println(combos);
    }

    private static List<List<Integer>> kSizedCombos(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(arr, 0, new ArrayList<>(), result, k);
        return result;
    }

    private static void backTrack(int[] arr, int start, List<Integer> current, List<List<Integer>> result, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
        }
        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            backTrack(arr, i + 1, current, result, k);
            current.removeLast();
        }
    }
}
