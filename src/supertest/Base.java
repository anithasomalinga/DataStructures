package supertest;

public class Base {
    private String message;
    public Base(String msg) {
        this.message = msg;
    }
    public void print() {
        System.out.println(message);
    }
}
