package leetcode.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] data = {5,2,4};
        int target = 9;
        System.out.println(Arrays.toString(getTwoSumIndeces(data,target)));

    }

    private static int[] getTwoSumIndeces(int[] data, int target) {
        Map<Integer, Integer> complementIndexMap = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (complementIndexMap.get(data[i]) == null) {
                complementIndexMap.put(target - data[i], i);
            } else {
                return new int[]{i, complementIndexMap.get(data[i])};
            }
        }
        return null;
    }

    public int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> complimentMap = new HashMap<>();
        for(int i=0; i< array.length;i++) {
            if(complimentMap.containsKey(array[i])){
                return new int[] {complimentMap.get(array[i]), i};
            } else {
                complimentMap.put(target-array[i], i);
            }
        }
        return null;
    }
}
