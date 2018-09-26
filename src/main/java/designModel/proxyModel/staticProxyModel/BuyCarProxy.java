package designModel.proxyModel.staticProxyModel;

public class BuyCarProxy implements IBuyCar {

    private Customer customer;//接受买车客户

    public BuyCarProxy (Customer customer){
        this.customer = customer;
    }

    @Override
    public void buyCar() {
        customer.buyCar();
    }
}
