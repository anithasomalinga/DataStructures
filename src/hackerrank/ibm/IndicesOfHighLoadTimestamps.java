package hackerrank.ibm;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IndicesOfHighLoadTimestamps {
    public static void main(String[] args) {
        int[] loads  = {1, 2, 9};
        System.out.println(Arrays.toString(getHighLoadTimestamps(loads)));
    }

    static int[] getHighLoadTimestamps(int[] load) {
        // Write your code here
        int threshold = Arrays.stream(load).sum() / load.length;
        return IntStream.range(0, load.length).filter(i -> load[i] > threshold).toArray();
    }
}
