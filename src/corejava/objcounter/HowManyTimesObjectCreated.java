package corejava.objcounter;

public class HowManyTimesObjectCreated {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart();
        ShoppingCart cart2 = new ShoppingCart();
        ShoppingCart cart3 = new ShoppingCart();

        System.out.println("No of objects created: " + ShoppingCart.getHits());
    }
}
