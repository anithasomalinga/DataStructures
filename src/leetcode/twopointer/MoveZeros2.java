package leetcode.twopointer;

import java.util.Arrays;

public class MoveZeros2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 0, 4, 7, 1};
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
