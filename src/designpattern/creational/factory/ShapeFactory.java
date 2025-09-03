package designpattern.creational.factory;

public class ShapeFactory {
    public Shape getShape(String shape) {
        if(shape.equals("CIRCLE")) {
            return new Circle();
        } else if (shape.equals("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}
