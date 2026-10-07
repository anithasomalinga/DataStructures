package leetcode.binaryoperations;

import java.util.Scanner;

public class IntToBinary {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = Integer.parseInt(scanner.nextLine());
//        String binaryInt = convIntToBinary(num);
//        System.out.println("Result -> " + binaryInt);
        int num = 64;
        System.out.println(Integer.toBinaryString(64));
        System.out.println(~5);
    }

        private static String convIntToBinary(int num) {
            if (num == 0) return String.valueOf(0);
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                int x = num % 2;
                System.out.println("num % 2: " + x);
                sb.append(x);
                num /= 2;
                System.out.println("num /= 2: " + num);
            }
            return sb.reverse().toString();
        }
}
