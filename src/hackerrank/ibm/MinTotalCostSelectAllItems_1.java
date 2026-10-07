package hackerrank.ibm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MinTotalCostSelectAllItems_1 {
    public static void main(String[] args) {
        int noOfItems = 4;
        int[] itemId = {2,0,1,2};
        int[] cost = {8,7,6,9};
        Map<Integer, Integer> minCostMap = new HashMap<>();
        IntStream.range(0, noOfItems).forEach(i -> {
            minCostMap.merge(itemId[i], cost[i], Math::min);
        });
        System.out.println(minCostMap.values().stream().mapToInt(Integer::intValue).sum());
    }
}
