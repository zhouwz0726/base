package designModel.proxyModel.staticProxyModel;

public class Customer implements IBuyCar {

    private int cashCar;//购车金额

    public int getCashCar() {
        return cashCar;
    }

    public void setCashCar(int cashCar) {
        this.cashCar = cashCar;
    }

    @Override
    public void buyCar() {
        System.out.println("买了一辆车花费了：" + cashCar);
    }
}
