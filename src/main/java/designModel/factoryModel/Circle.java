package designModel.factoryModel;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle类的draw方法被调用了");
    }
}
