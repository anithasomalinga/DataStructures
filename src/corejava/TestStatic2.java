package corejava;

public class TestStatic2 {
    public static void main(String[] args) {
        System.out.println(StaticVariables.number);
        StaticVariables.someMethod();
        System.out.println(StaticVariables.number);
    }
}
