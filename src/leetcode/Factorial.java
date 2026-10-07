package leetcode;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Enter a number to find the factorial or char to exit");
        boolean go = true;
        while (go) {
            try {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                System.out.println("Factorial is: " + factorial(num));
            } catch (Exception e) {
                go = false;
            }
        }
    }

    private static int factorial(int num) {
        int fact = 1;
        int i = 1;
        while (i <= num) {
            fact *= i;
            i++;
        }
        return fact;
    }
}
