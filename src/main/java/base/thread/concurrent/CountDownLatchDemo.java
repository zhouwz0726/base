package base.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch:闭锁，它允许一个或多个线程等待一系列指定操作的完成
 * CountDownLatch 以一个给定的数量初始化。countDown() 每被调用一次，这一数量就减一。通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
 * 例子：假设需要做完三个动作，1：订机票；2：订巴士；3：订酒店；等待三个线程做完之后才可以出发
 * @author zhouwz
 * */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("订机票");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("订巴士");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("订酒店");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            countDownLatch.await();
            System.out.println("可以出发了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
