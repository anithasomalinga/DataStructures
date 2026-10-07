package hackerrank.ibm;

import java.util.Scanner;

public class ValidIP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        // 999.999.999.999
        String regex = "(?:\\d{1,3}\\.){3}\\d{1,3}";
        System.out.println("999.999.999.999 format: " + ip.matches(regex));
        // Valid IPv4 - 255.255.255.255
        String octectRegex = "^(?:(2[0-5]{2}|1[0-9]{2}|[0-9]|[1-9]\\d)\\.){3}(?:2[0-5]{2}|1[0-9]{2}|[0-9]|[1-9]\\d)$";
        System.out.println("255.255.255.255 format: " + ip.matches(octectRegex));


    }
}
