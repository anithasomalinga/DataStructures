package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 442 - Find all duplicates in an array
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
 * each integer appears at most twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
 * excluding the space needed to store the output
 */
public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[] {4, 3, 2, 7, 8, 2, 3, 1};
        int n = nums.length;
        // mark visited index position as negative, so any duplicate will again want to mark negative
        // and we find its already negative then we identify the duplicate
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            // Calculate the corresponding index (0-based)
            int idx = num - 1;
            // If the value at this index is already negative, it means we have
            // encountered this number before, so it is a duplicate.
            if(nums[idx] < 0) {
                output.add(num);
            } else {
                nums[idx] = -nums[idx];
            }
        }
        System.out.println("Duplicates: " + output);
    }
}
