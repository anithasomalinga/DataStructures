package leetcode.twopointer;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Not 2 pointer
public class Anagram {
    public static void main(String[] args) {
        boolean result = isAnagramMapCharCount("greata", "trgea");
        System.out.println(result ? "Is anagram" : "Not an anagram");
    }

    private static boolean isAnagram(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }

    private static boolean isAnagramCounting(String string1, String string2) {
        int CHARACTER_RANGE= 256;
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramGuavaMultiSet(String text1, String text2) {
        if(text1.length()!=text2.length()) return false;
        Multiset<Character> char1 = HashMultiset.create();
        Multiset<Character> char2 = HashMultiset.create();
        IntStream.range(0, text1.length()).forEach(i -> {
            char1.add(text1.charAt(i));
            char2.add(text1.charAt(i));
        });
//        System.out.println((char) 103);
        return char1.equals(char2);
    }

    // For example, “A decimal point” and “I’m a dot in place.” would be anagrams of each other.
    // That is, let’s only consider the rearrangement of case-insensitive letters, irrespective of other
    // characters such as white spaces and punctuations.
    private static boolean isAnagramLetterBased(String text1, String text2) {
//        char[] char1 = text1.toCharArray();
//        char[] char2 = text2.toCharArray();
        text1 = "A decimal point";
        text2 = "I’m a dot in place.";

        boolean result = isAnagramGuavaMultiSet(preprocess(text1), preprocess(text2));


        // PLAY WITH JAVA 8 STREAMS
        Map<Character, Long> char1 = text1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        List<Integer> codes = text2.chars().boxed().toList();
        Map<Integer, Long> char2 = text2.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<String, Integer> map = new HashMap<>();
        map.put("potter", map.getOrDefault("potter", 0) + 1);
        map.put("ani", 1);
        map.put("ani", 5); // put overrides
        // replace -Updates the value only if the key already exists.
        map.replace("tet", 1); // does nothing
        // map.replace("ani", 5, 2); // only replaces if current value is 1 // conditional replace!!
        System.out.println(map.get("potter"));
        System.out.println(map.get("ani"));
        System.out.println(map.get("tet"));
        return result;
    }

    private static String preprocess(String str) {
        return str.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    private static boolean isAnagramJava8V(String text1, String text2) {
        System.out.println(text1.chars().sorted().boxed().toList());
        return text1.chars().sorted().boxed().toList().equals(text2.chars().sorted().boxed().toList());
    }

    private static boolean isAnagramMapCharCount(String text1, String text2) {
        Map<Character, Long> map1 = text1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Long> map2 = text1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Integer> countMap = new HashMap<>();
        // Count characters from first string
//        IntStream.range(0, text1.length()).forEach(i -> countMap.put(text1.charAt(i), countMap.getOrDefault(text1.charAt(i), 0) + 1));
        // or
//        text1.chars().forEach(c -> countMap.put((char) c, countMap.getOrDefault((char) c, 0) + 1));
        if (text1.length()!=text2.length())return false;
        text1.chars().forEach(c -> countMap.put((char) c, countMap.getOrDefault((char) c, 0) + 1));

        // subtract counts using second string
        boolean valid = text2.chars().mapToObj(c -> (char) c).allMatch(c -> {
            if(!countMap.containsKey(c)) return false;
            countMap.put(c, countMap.get(c) - 1);
            return countMap.get(c) >=0;
        });
        return valid;
    }
}
