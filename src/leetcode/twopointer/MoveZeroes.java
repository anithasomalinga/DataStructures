package leetcode.twopointer;

import java.util.Arrays;

public class MoveZeroes {
    /*
    public static void main(String[] args) {
        int[] array = new int[] {1, 0, 0, 3};
        int j = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(array));
    }*/
    public static void main(String[] args) {
        int[] nums = new int[] {0, 3, 0, 4, 7, 0};
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
