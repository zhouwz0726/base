package designModel.factoryModel;

public class ShapeFactory {

    public Shape getShape(String shapeType){
        if(null == shapeType){
            return null;
        }
        if("circle".equalsIgnoreCase(shapeType)){
            System.out.println("Circle类被实例化了：");
            return new Circle();
        }
        if("square".equalsIgnoreCase(shapeType)){
            System.out.println("Square类被实例化了：");
            return new Square();
        }
        return null;
    }
}
