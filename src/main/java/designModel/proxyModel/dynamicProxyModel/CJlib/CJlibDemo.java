package designModel.proxyModel.dynamicProxyModel.CJlib;

import org.springframework.cglib.proxy.Enhancer;

public class CJlibDemo {

    public static void main(String[] args) {
        Book book=new Book();
        BookCglibProxy  cglib=new BookCglibProxy();
        Book bookCglib=(Book)cglib.getInstance(book);
        bookCglib.buyBook();
    }
}
