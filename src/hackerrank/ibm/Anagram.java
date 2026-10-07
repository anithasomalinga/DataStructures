package hackerrank.ibm;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";
        int[] chars = new int[255];
        for(int i = 0; i < str1.length(); i++) {
            chars[str1.charAt(i)]++;
            chars[str2.charAt(i)]--;
        }
        boolean isAnagram = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                isAnagram = false;
                break;
            }
        }
        System.out.println(isAnagram);
    }
}
