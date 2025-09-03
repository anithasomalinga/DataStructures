package designpattern.creational.abstractfactory;

public class VintageTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a vintage table");
    }
}
