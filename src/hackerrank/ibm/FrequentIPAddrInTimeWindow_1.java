package hackerrank.ibm;

import java.util.*;
import java.util.stream.IntStream;

public class FrequentIPAddrInTimeWindow_1 {
    public static void main(String[] args) {
        int k = 2;
        int t = 5;
        // which ip appear more than k times for any ts t apart
        int[] ips = {1, 1, 1, 1, 2, 2, 2};
        int[] ts = {10, 12, 15, 30, 31, 32, 35};

        Map<Integer, List<Integer>> tMap = new HashMap<>();
        IntStream.range(0, ips.length).boxed().forEach(i -> tMap.computeIfAbsent(ips[i], key -> new ArrayList<>()).add(ts[i]));
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
            int ip = entry.getKey();
            List<Integer> tList = entry.getValue();
            int left = 0;
            for(int right = 0; right < tList.size(); right++) {
                while (tList.get(right) - tList.get(left) > t) {
                    left++;
                }
                int count = right - left + 1;
                if (count > k) {
                    result.add(ip);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
