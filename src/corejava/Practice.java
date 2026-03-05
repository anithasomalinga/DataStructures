package corejava;

public class Practice {
    public static void main(String[] args) {
        String name = "sam";
        StringBuilder res = new StringBuilder();
        for(int i = name.length() - 1; i >=0; i--){
            res.append(name.charAt(i));
        }
        System.out.println(res);
        int a = 5;
        int b = 10;
        a = a+b;
        b = a-b;
//        System.out.println(b);
        a = a-b;
        System.out.println(a + " " +b);
    }
}
