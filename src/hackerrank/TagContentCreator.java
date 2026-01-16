package hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentCreator {

    // Test input
    // 3
    // <h1>test</h1> => test
    // <h1><a>ani</a>abc</h1> => ani
    // <h1>mnm</h> => None
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String regex = "<(.+?)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        while(testCases>0){
            String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group(2));
                found = true;
            }
            if(!found) {
                System.out.println("None");
            }
            testCases--;
        }
    }
}
