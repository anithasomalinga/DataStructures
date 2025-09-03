    package leetcode;

    import java.util.*;

    public class LongestConsecutiveSequence128 {
        public static void main(String[] args) {
            int[] array = new int[] {202, 100,4,200,1,204,3,203, 2, 201, -1, -2, 0};
            int length = array.length;
            Set<Integer> set = new HashSet<>(length);
            for(int  n : array) {
                set.add(n);
            }
            array = set.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(array);
            int currSeqLength = 1;
            int maxSeqLength = 1;
            for(int i = 0; i < length; i ++) {
                if (i != length -1 && array[i+1] == array[i] + 1) {
                    currSeqLength++;
                } else {
                    maxSeqLength = Math.max(maxSeqLength, currSeqLength);
                    currSeqLength = 1;
                }
            }
            System.out.println(maxSeqLength);
        }
    }
