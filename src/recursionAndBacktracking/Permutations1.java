package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations1 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        List<List<Integer>> result = new ArrayList<>();
        permutate(result, nums, 0);
        System.out.println("Permutations count: " + result.size());
        System.out.println(result);
    }

    private static List<List<Integer>> permutate(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> set = Arrays.stream(nums).boxed().toList();
            result.add(set);
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permutate(result, nums, start + 1);
            swap(nums, i, start);
        }
        return result;
    }

    private static void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
