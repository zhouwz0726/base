package JDK8.Lambda;

import java.util.function.Supplier;

public class Lambda {

    public static void main(String[] args) {
        //Lambda表达式
        lambda();
    }

    /**
     * Lambda表达式
     * */
    private static void lambda() {
        Supplier<Integer> supplier = ()->{
            return 1;
        };
        System.out.println(supplier.get());
    }

}
