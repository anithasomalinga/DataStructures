package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutation1 {
    public static void main(String[] args) {
        System.out.println("Enter the string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> result = new ArrayList<>();
        permutate(str, result, "");
        System.out.println(result);
    }

    private static void permutate(String str, List<String> result, String answer) {
        if (str.isEmpty()) {
            result.add(answer);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            String rest = left + right;
            permutate(rest, result, answer + ch);
        }
    }
}
