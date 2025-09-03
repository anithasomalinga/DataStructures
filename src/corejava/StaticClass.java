package corejava;

public class StaticClass {
    public static void main(String[] args) {
        System.out.println(OuterClass.InnerClass.b);
        System.out.println(OuterClass.InnerClass.b);
    }
}

class OuterClass {
    static class InnerClass {
        int a;
        static int b;
    }
}
