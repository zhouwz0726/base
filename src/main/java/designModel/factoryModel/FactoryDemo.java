package designModel.factoryModel;

public class FactoryDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        //Circle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("SQUARE");
        //调用 Circle 的 draw 方法
        shape2.draw();
    }
}
