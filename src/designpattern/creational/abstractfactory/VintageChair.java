package designpattern.creational.abstractfactory;

public class VintageChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Using a vintage chair");
    }
}
