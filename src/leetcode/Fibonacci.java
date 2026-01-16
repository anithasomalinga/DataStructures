package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {
        var n = 6;
        int i = 0, j = 1;
        int cnt = 2;
        System.out.print(i + " " + j + " ");
        while (cnt <= n-1) {
            int sum = i + j;
            i = j;
            j = sum;
            System.out.print(j + " ");
            cnt++;
        }
        printFibonnaci(6);
        fibonnaciRecursive(6);
    }



    // while loop
    // Time complexity is Linear - O(n)
    // Space complexity is Constant - O(1)
    public static void printFibonnaci(int n) {
        int i=0, j=1;
        int cnt = 2;
        List<Integer> fib = new ArrayList<>(n);
        fib.add(i);
        fib.add(j);
        while (cnt<n) {
            int sum = i + j;
            fib.add(sum);
            i = j;
            j = sum;
            cnt++;
        }
        System.out.println(fib);
    }

    // fast algorithm - memoization
    // Memoization offers a good balance of clarity and efficiency for recursive solutions.
    // Time and Space complexity - O(n)

    static Map<Integer, Long> cache = new HashMap<>();
    private static void fibonnaciRecursive(int terms) {
        System.out.println("Fibonacci Series of " + terms + " terms:");
        for (int i = 0; i < terms; i++) {
            // Call the memoized fibonacci function for each term
            System.out.print(fibonnaci(i));
            if (i < terms - 1) {
                System.out.print(", ");
            }
        }
    }

    private static long fibonnaci(int n) {
        if (n <= 1) {
            return n; // base case: f(0) = 0 and f(1) = 1
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // if not in cache, calc the result recursively - F(n-1) + F(n-2)
        long result = fibonnaci(n-1) + fibonnaci(n-2);
        cache.put(n, result);
        return result;
    }


}
