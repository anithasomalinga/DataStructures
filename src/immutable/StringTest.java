package immutable;

public class StringTest {
    public static void main(String[] args) {
        String str = "anitha";
        System.out.println("str: " + str);
        String result = modifyStr(str);
        System.out.println("str: " + str);
        System.out.println("result: " + result);
    }
    private static String modifyStr(String str) {
        str = "madhan";
        return str;
    }
}
