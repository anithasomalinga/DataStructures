package corejava;

public class ThreeDotOnMainStrParam {
    public static void main(String...args) {
        System.out.println("hello");
        test(1);
    }

//    private static void test(Character a) {
//        System.out.println("Character");
//    }
    private static void test(long a) {
        System.out.println("long: " + a);
    }
//    private static void test(int... a) {
//        System.out.println("int");
//    }
//    private static void test(Object a) {
//        System.out.println("Object");
//    }
}
