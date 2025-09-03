package corejava.objcounter;

public class ShoppingCart {
    private static int counter;

    public ShoppingCart() {
        counter++;
    }

    public static int getHits() {
        return counter;
    }

    public void displayItems() {

    }
}
