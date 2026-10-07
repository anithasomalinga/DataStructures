package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // Time Complexity O(n*n!)
    // Space Complexity O(n)
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, int start) {
        // Base case: If we have fixed all elements, add the current permutation to the result
        if (start == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        // Recursive choices: Swap the element at 'start' with every element after it
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);          // Choose: Make a swap
            backtrack(result, nums, start + 1); // Explore: Recurse for the next position
            swap(nums, start, i);          // Unchoose: Backtrack by swapping back
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1};
        int[] nums = {1, 2};
//        int[] nums = {1, 2, 3};
        List<List<Integer>> allPermutations = permute(nums);

        System.out.println("Total Permutations: " + allPermutations.size());
        System.out.println(allPermutations);
    }
}
