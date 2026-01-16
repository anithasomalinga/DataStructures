package hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class ValidIP{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String IP = in.nextLine();
//        while(in.hasNext()){
//            IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));

        Pattern p = Pattern.compile(new MyRegex().pattern);

        Matcher m = p.matcher(IP);
        while (m.find()) {
            System.out.println(m.group() + " " +m.group(1));
        }
    }
}

//Write your code here
class MyRegex {
    // 000.000.000.000 to 999.999.999.999
     String pattern = "(?:\\d{1,3}\\.){3}\\d{1,3}";
//    String pattern = "\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|[2][0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|[2][0-4][0-9]|[01]?[0-9][0-9]?)\\b";
    //b  - word boundary
    // [01]? - optional 0 or 1
    // (?:..) - non-capturing group
}
