package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int arrLength = nums1.length < nums2.length ? nums1.length : nums2.length;
//        int[] instersection = new int[arrLength];
        Set<Integer> largeSet = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

//        int[] instersection = Arrays.stream(nums1).filter(largeSet::contains).toArray();
        int[] intersection = intersect1(nums1,nums2);
        System.out.println(Arrays.toString(intersection));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] small = nums1.length <= nums2.length ? nums1 : nums2;
        int[] large = nums1.length > nums2.length ? nums1 : nums2;

        List<Integer> largeList = Arrays.stream(large).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        Arrays.stream(small).boxed().forEach(n-> {
            if(largeList.contains(n)) {
                result.add(n);
                largeList.remove(n);
            }
        });
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    // better efficiency
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for(int n : nums1) {
            nums1Map.put(n, nums1Map.getOrDefault(n, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< nums2.length; i++) {
            if(nums1Map.getOrDefault(nums2[i], 0) > 0) {
                result.add(nums2[i]);
                nums1Map.put(nums2[i], nums1Map.get(nums2[i]) - 1);
            }
        }
        Arrays.copyOfRange(nums1, 0, 3);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
