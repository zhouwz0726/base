package designModel.proxyModel.staticProxyModel;

public class Demo {

    /**
    * @Author:zhouwz
     * 静态代理模式
     * 例子：当我们需要购买汽车的时候，必须要通过汽车4s店，4s店充当代理角色，其目的就是控制用户买车必须通过4s店才能从厂商买到一辆车
     * 重点：1：需要一个买车的接口(IBuyCar)
     *      2：声明买车的客户，实现买车的接口(Customer)
     *      3：声明买车代理汽车4s店，也需要实现接口，必须接受客户下单
    */
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCashCar(10000);
        BuyCarProxy buyCarProxy = new BuyCarProxy(customer);
        buyCarProxy.buyCar();
    }

}
