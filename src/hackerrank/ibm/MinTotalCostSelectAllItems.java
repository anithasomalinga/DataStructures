package hackerrank.ibm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MinTotalCostSelectAllItems {
    public static void main(String[] args) {
        int noOfItems = 4;
        int[] itemId = {2,0,1,2};
        int[] cost = {8,7,6,9};
        int minTotalCost = minTotalCost(noOfItems, itemId, cost);
        System.out.println(minTotalCost);
    }
    /*static int minTotalCost(int noOfItems, int[] itemId, int[] cost) {
        Map<Integer, Integer> itemMinCostMap = new HashMap<>();
        IntStream.range(0, noOfItems).forEach(i -> {
            if (itemMinCostMap.get(itemId[i]) != null) {
                if(itemMinCostMap.get(itemId[i]) > cost[i]) {
                    itemMinCostMap.put(itemId[i], cost[i]);
                }
            } else {
                itemMinCostMap.put(itemId[i], cost[i]);
            }
        });
        return itemMinCostMap.values().stream().mapToInt(Integer::intValue).sum();
    }*/

    // cleaner java implementation
    static int minTotalCost(int noOfItems, int[] itemId, int[] cost) {
        Map<Integer, Integer> itemMinCostMap = new HashMap<>();
        IntStream.range(0, noOfItems).forEach(i -> {
            itemMinCostMap.merge(itemId[i], cost[i], Math::min);
        });
        return itemMinCostMap.values().stream().mapToInt(Integer::intValue).sum();
    }
}
