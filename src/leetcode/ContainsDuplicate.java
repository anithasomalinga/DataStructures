package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1,3};
        containsDuplicateHashSetAdd(nums); // not very efficient

    }

    private static void containsDuplicateSimpleCode(int[] nums) {
        System.out.println("before:" + nums.length);
        long size = Arrays.stream(nums).distinct().count();
        System.out.println("after:" + size);
    }

    private static void containsDuplicateHashSetAnyMatch(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        boolean found = Arrays.stream(nums).anyMatch(n -> !sets.add(n));
        System.out.println("contains duplicate:" + found);
    }

    private static void containsDuplicateHashSetAdd(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        boolean found = false;
        for (int n : nums) {
            if(!sets.add(n)) found = true;
        }
        System.out.println("contains duplicate:" + found);
    }
}
