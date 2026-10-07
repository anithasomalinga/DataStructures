package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Time Complexity O(n*n!)
// Space Complexity O(n)
public class StringPermutation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s;
        String answer="";

        System.out.print("Enter the string : ");
        s = scan.next();

        System.out.print("\nAll possible strings are : ");
        List<String> result = new ArrayList<>();
        permute(result, s, answer);
        System.out.println(result);
        System.out.println("count: " + result.size());

//        String t = "abc";
//        System.out.println("substr(0,0): " + t.substring(0,0) + " -- ");
//        System.out.println("substr(0,1): " + t.substring(0,1) + " -- ");
//        System.out.println("substr(0,2): " + t.substring(0,2) + " -- ");
//        System.out.println("substr(1): " + t.substring(1) + " -- ");
//        System.out.println("substr(2): " + t.substring(2) + " -- ");
//        System.out.println("substr(3): " + t.substring(3) + " -- ");
    }
    static void permute(List<String> result, String s, String answer)
    {
        if (s.isEmpty())
        {
            result.add(answer);
            return;
        }

        for(int i = 0 ; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(result, rest, answer + ch);
        }
    }
}
