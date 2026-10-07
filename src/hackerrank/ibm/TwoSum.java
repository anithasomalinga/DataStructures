package hackerrank.ibm;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] data = {5,2,4};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Integer index = map.get(data[i]);
            if (index != null) {
                result.add(index);
                result.add(i);
                break;
            }
            map.put(target - data[i], i);
        }
        System.out.println(result);
    }
}
