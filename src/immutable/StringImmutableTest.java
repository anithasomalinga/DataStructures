package immutable;

public class StringImmutableTest {
    public static void main(String[] args) {
        String str = "abc";
        int x = 10;
        Integer y = 10;
        StringBuilder builder = new StringBuilder("abc");
        System.out.printf("before method call: %s %s %s %s \n", str, builder, x, y);
        modifyString(str, builder, x, y);
        System.out.printf("after method call: %s %s %s %s\n", str, builder, x, y);
        str += "222";
        builder = new StringBuilder("222");
        x = 30;
        y = 30;
        System.out.printf("%s %s %s %s\n", str, builder, x, y);
    }

    private static void modifyString(String s, StringBuilder builder, int x, Integer y) {
        System.out.println("method start");
        s += "111";
        builder.append("111");
        x = 20;
        y = 20;
        System.out.printf("%s %s %s %s\n", s, builder, x, y);
//        System.out.println(x);
        System.out.println("method end");
    }
}
