package hackerrank.ibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IndicesOfHighLoadTimestamps_1 {
    public static void main(String[] args) {
        int n = 3;
        int[] load = {1, 2, 9};
        int sum = Arrays.stream(load).sum();
        int avg = sum / n;
        System.out.println(Arrays.toString(IntStream.range(0, n).filter(i -> load[i] > avg).toArray()));
    }
}
