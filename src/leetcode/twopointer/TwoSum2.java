package leetcode.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] data = {5,2,4};
        int target = 9;
        System.out.println(Arrays.toString(getTwoSumIndexes(data,target)));
    }
    public static int[] getTwoSumIndexes(int[] data, int target) {
        Map<Integer, Integer> complimentMap = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (complimentMap.containsKey(data[i])) {
                return new int[] {complimentMap.get(data[i]), i};
            }
            complimentMap.put(target - data[i], i);
        }
        return null;
    }
}
