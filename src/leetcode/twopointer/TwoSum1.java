package leetcode.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] data = {7,6,8,2}; // sorted - 9, 8, 6, 2
        int target = 8;
        System.out.println(Arrays.toString(getTwoSumIndeces(data,target)));

    }

    private static int[] getTwoSumIndeces(int[] data, int target) {

//        Arrays.sort(data);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if(map.get(data[i]) == null){
                map.put(target - data[i], i);
            } else {
                return new int[]{map.get(data[i]), i};
            }
        }
        return null;
    }
}
