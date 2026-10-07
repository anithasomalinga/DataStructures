package immutable;

public class PrimitiveTest {
    public static void main(String[] args) {
        int num = 10;
        changeNum(num);
        System.out.println(num);
    }
    private static void changeNum(int num) {
        num = 20;
    }
}
