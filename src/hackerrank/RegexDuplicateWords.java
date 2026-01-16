package hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(\\s+\\1)+\\b";

        /**
         * Explanation:
         *
         * RegEx Pattern: \\b(\\w+)(\\s+\\1)+\\b
         *
         * \\b - Word boundary
         * (\\w+) - Capture group 1: matches one or more word characters (the first occurrence)
         * (\\s+\\1)+ - Capture group 2: matches one or more whitespace followed by a backreference to group 1 (\\1), repeated one or more times
         * \\b - Word boundary
         *
         *
         * Case-Insensitive Flag: Pattern.CASE_INSENSITIVE
         *
         * This makes the pattern match words regardless of case
         *
         *
         * replaceAll Arguments: m.group() and m.group(1)
         *
         * m.group() - The entire matched text (including all repetitions)
         * m.group(1) - Just the first captured group (the first occurrence of the word)
         *
         *
         *
         * Example: For I love Love to To tO code:
         *
         * The pattern matches Love to To tO (love and its repetitions, to and its repetitions)
         * Each match is replaced with its first captured group
         * Result: I love to code
         * is m.group(0) return11:42 PMYes, m.group(0) and m.group() return the same thing - they both return the entire matched text.
         * Here's the breakdown:
         *
         * m.group() or m.group(0) - Returns the entire matched sequence
         * m.group(1) - Returns the first captured group (content within the first set of parentheses)
         * m.group(2) - Returns the second captured group (content within the second set of parentheses)
         * And so on...
         */


        /**
         * Capturing vs Non-Capturing:
         * java// CAPTURING group (with parentheses only):
         * String pattern = "(\\d{1,3}\\.)";
         * // Each match is "captured" and can be retrieved with matcher.group(1), group(2), etc.
         *
         * // NON-CAPTURING group (with ?:):
         * String pattern = "(?:\\d{1,3}\\.)";
         * // The group is used for structure/repetition but NOT captured
         * In your IP regex:
         * java(?:\\d{1,3}\\.){3}
         * //↑ non-capturing group that repeats 3 times
         * This means:
         *
         * (?:...) = group the pattern together
         * {3} = repeat this group exactly 3 times
         * But DON'T capture/save each match
         *
         * Why use ?: (non-capturing)?
         *
         * Performance - Non-capturing groups are faster (no memory needed to store matches)
         * Cleaner - We don't need to access individual octets in the regex match
         * Simplicity - Keeps group numbering simple if you add other capturing groups later
         */



        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher m = p.matcher(input);
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}