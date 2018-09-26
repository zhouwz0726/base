package designModel.proxyModel.dynamicProxyModel.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @Author:zhouwz
 * 声明一个代理类，实现InvocationHandler接口
*/
public class DynamicProxy implements InvocationHandler {

    Object object;//被代理类的实例

    public DynamicProxy(Object object){
        this.object = object;
    }

    /**
     * 声明一个代理类，实现invocationHandler接口，并重写invoke方法
     * 动态代理可以在不改变原有代码的情况下进行扩展。如下面的before和after
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /*
         * before ：doSomething();
         */
        System.out.println("代理执行" +method.getName() + "方法");
        Object result = method.invoke(this.object, args);

        /*
         * after : doSomething();
         */

        return null;
    }
}
