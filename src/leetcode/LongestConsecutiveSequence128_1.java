package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128_1 {
    public static void main(String[] args) {
        int[] array = {100, 200, 102, 104, 1, 101, 3, 2, 103};
        int length = longestConsecSeq(array);
        System.out.printf("length=%d",length);
    }

    private static int longestConsecSeq(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        int maxSeqLength = 0;
        for (int n : set) {
            if (!set.contains(n-1)) {
                int currNum = n;
                int currSeqLength = 1;
                while(set.contains(currNum+1)){
                    currSeqLength++;
                    currNum++;
                }
                maxSeqLength = Math.max(maxSeqLength, currSeqLength);
            }
        }
        return maxSeqLength;
    }
}
