package designpattern.creational;

import designpattern.creational.abstractfactory.*;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // create modern furniture using ModernFurnitureFactory
        FurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFurnitureFactory.createChair();
        Table modernTable = modernFurnitureFactory.createTable();
        modernChair.sitOn();
        modernTable.use();

        // create vintage furniture using VintageFurnitureFactory
        FurnitureFactory vintageFurnitureFactory = new VintageFurnitureFactory();
        Chair vintageChair = vintageFurnitureFactory.createChair();
        Table vintageTable = vintageFurnitureFactory.createTable();
        vintageChair.sitOn();
        vintageTable.use();
    }
}
