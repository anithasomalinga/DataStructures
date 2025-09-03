package leetcode;

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
    }
}
