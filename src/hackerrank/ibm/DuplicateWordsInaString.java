package hackerrank.ibm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWordsInaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        removeConsecutiveDuplicates(sentence);
        findDuplicates(sentence);
    }

    private static void removeConsecutiveDuplicates(String sentence) {
        String regex = "\\b(\\w+)(\\s+\\1)+\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(sentence);
        while (m.find()) {
            sentence = sentence.replaceAll(m.group(), m.group(1));
        }
        System.out.println(sentence);
    }

    private static void findDuplicates(String sentence) {
        String[] words = sentence.split("\\W+"); // split between Non word character
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.merge(words[i], 1, Integer::sum);
        }
        System.out.println(map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList());
    }
}
