package hackerrank.ibm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequentIPAddrInTimeWIndow {
    /**
     * Frequent IP Addresses in a Time Window
     * Problem Statement
     * <p>
     * Given arrays of IP addresses and their respective timestamps, find all IP addresses that appear more than k times within any t-second window.
     * If no such IP addresses exist, return an empty array.
     * <p>
     * Input
     * <p>
     * ip: an array of integers representing IP addresses.
     * <p>
     * timestamp: an array of integers representing the timestamps for each IP.
     * <p>
     * k: an integer threshold for the number of occurrences.
     * <p>
     * t: an integer representing the time window in seconds.
     * <p>
     * Output
     * <p>
     * An array of integers representing the IP addresses that appear more than k times within any t-second window. Return an empty array if none exist.
     * <p>
     * Example
     * <p>
     * n = 3
     * ip = [1, 2, 1]
     * timestamp = [6, 10, 15]
     * k = 1
     * t = 10
     * <p>
     * # Output
     * [1]
     */
    public static void main(String[] args) {
        int k = 2;
        int t = 5;
        // which ip appear more than k times for any ts t apart
        int[] ips = {1, 1, 1, 1, 1, 1, 1};
        int[] ts = {10, 12, 15, 30, 31, 32, 35};
//        int[] ips = {1, 1, 1, 1, 1, 1};
//        int[] ts = {0, 0, 0, 0, 0, 5};
        Map<Integer, List<Integer>> ipRepeats = new HashMap<>();
        for (int i = 0; i < ips.length; i++) {
            ipRepeats.computeIfAbsent(ips[i], key -> new ArrayList<>()).add(ts[i]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : ipRepeats.entrySet()) {
            int ip = entry.getKey();
            List<Integer> tList = entry.getValue();
            Collections.sort(tList);
            int left = 0;
            for (int right = 0; right < tList.size(); right++) {
                while (tList.get(right) - tList.get(left) > t) {
                    left++;
                }
                if(((right - left) + 1) > k) {
                    System.out.println(ip);
                    break;
                }
            }
        }
//        List<Integer> bruteForce = getFrequentIPsBruteForce(Arrays.stream(ips).boxed().toList(), Arrays.stream(ts).boxed().toList(), k, t);
//        System.out.println("#####################");
//        List<Integer> optimal = getFrequentIPsOptimal(Arrays.stream(ips).boxed().toList(), Arrays.stream(ts).boxed().toList(), k, t);
//        System.out.println(bruteForce);
//        System.out.println(optimal);
    }

    public static List<Integer> getFrequentIPsBruteForce(List<Integer> ip, List<Integer> timestamp, int k, int t) {
        // Group timestamps by IP address
        Map<Integer, List<Integer>> ipMap = new HashMap<>();
        for (int i = 0; i < ip.size(); i++) {
            ipMap.computeIfAbsent(ip.get(i), x -> new ArrayList<>()).add(timestamp.get(i));
        }

        List<Integer> result = new ArrayList<>();

        // Process each IP independently
        for (Map.Entry<Integer, List<Integer>> entry : ipMap.entrySet()) {
            List<Integer> times = entry.getValue();
            int n = times.size();

            // OUTER LOOP: Treat every single element as the start of a window
            for (int i = 0; i < n; i++) {

                int count = 1; // Count the anchor element itself

                // INNER LOOP: Scan forward, re-checking future elements
                for (int j = i + 1; j < n; j++) {
                    System.out.print(" i: " + times.get(i));
                    System.out.println(" j: " + times.get(j));
                    if (times.get(j) - times.get(i) <= t) {
                        count++;
                    } else {
                        // Since times are sorted, once it exceeds 't', everything after will too
                        break;
                    }
                }

                // If this window crossed the threshold, flag the IP and stop checking this IP
                if (count > k) {
                    result.add(entry.getKey());
                    break;
                }
            }
            System.out.println();
        }

        Collections.sort(result);
        return result;
    }

    public static List<Integer> getFrequentIPsOptimal(List<Integer> ip, List<Integer> timestamp, int k, int t) {
        // Step 1: Group timestamps by IP address (Takes O(N) time)
        Map<Integer, List<Integer>> ipMap = new HashMap<>();
        for (int i = 0; i < ip.size(); i++) {
            ipMap.computeIfAbsent(ip.get(i), x -> new ArrayList<>()).add(timestamp.get(i));
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Apply the sliding window on each IP's sorted timestamp list
        for (Map.Entry<Integer, List<Integer>> entry : ipMap.entrySet()) {
            List<Integer> times = entry.getValue();
            int left = 0;

            // The 'right' pointer moves forward exactly once per element
            for (int right = 0; right < times.size(); right++) {
                System.out.print(" i: " + times.get(right));

                // Dynamic Cleanup: Shift 'left' forward if the past items are older than the cutoff
                // (Using a while loop ensures we clear out all stale elements)
                while (times.get(right) - times.get(left) > t) {

                    left++;
                    System.out.println(" j: " + times.get(left));
                }

                // Check if the current window size strictly exceeds 'k'
                if ((right - left + 1) > k) {
                    result.add(entry.getKey());
                    break; // Early Exit optimization: IP qualifies, skip remaining checks for it
                }
            }
        }

        // Sort the final unique frequent IPs numerically as per standard HackerRank requirements
        Collections.sort(result);
        return result;
    }

}
