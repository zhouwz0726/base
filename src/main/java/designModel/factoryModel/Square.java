package designModel.factoryModel;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square类的draw方法被调用了");
    }
}
