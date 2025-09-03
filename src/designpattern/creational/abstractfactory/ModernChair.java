package designpattern.creational.abstractfactory;

public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on modern chair");
    }
}
