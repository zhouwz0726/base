package thread.Thread.ClassLockAndObjectLock;

import sun.tools.tree.NewArrayExpression;

/**
 * 以下方法为了做测试，不考虑代码复用美观因素
 * test1方法，加锁在this代码块上，其实本质是对象锁
 * test2方法，加锁在方法上(注意这里不是静态方法)，其本质也是对象锁
 * test3方法，加锁在静态方法上，其本质是类加锁
 * test4方法，其本质是类加锁
 *
 * */
public class TestSynchronized {

    /**
     * 本质是对象锁
     * */
    public void test1(){
        synchronized (this){
            int i = 5;
            while (i-- > 0){
               System.out.println(Thread.currentThread().getName() + "：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 本质是对象锁
     * */
    public synchronized void test2(){
        int i = 5;
        while (i-- > 0){
            System.out.println(Thread.currentThread().getName() + "：" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 本质是类锁
     * */
    public static synchronized void test3(){
        int i = 5;
        while (i-- > 0){
            System.out.println(Thread.currentThread().getName() + "：" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 本质是类锁
     * */
    public void test4(){
        synchronized (TestSynchronized.class){
            int i = 5;
            while (i-- > 0){
                System.out.println(Thread.currentThread().getName() + "：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        /**
         * test1方法和test2方法都是对象锁，当我们只new一个testSynchronized对象时候，开启thread1和thread2线程，
         * 其实他们是同一个对象，故二个线程都需要获取该对象锁，故另一个线程必须等待，输出结果也是直观看到
         * 总结：同一个对象，对象锁之间的比较，互相影响
         * */
        TestSynchronized testSynchronized1 = new TestSynchronized();
        Thread thread1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized1.test1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized1.test2();
            }
        });
        thread1.start();
        thread2.start();

        /**
         * 这里同样调用对象锁，但是，我们new了2个对象，那么一个对象锁只能锁住自己对象，即testSynchronized2对象在调用test1时候，需要获取testSynchronized2对象的锁，
         * testSynchronized3对象在调用test1时候，需要获取testSynchronized3对象的锁，故二个对象锁，他互不影响，不需要等待另一个线程结束，
         * 输出结果也是二个线程同时输出
         * 总结：多个对象，对象锁之间的比较，互不影响
         * */
        TestSynchronized testSynchronized2 = new TestSynchronized();
        TestSynchronized testSynchronized3 = new TestSynchronized();
        Thread thread3 =  new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized2.test1();
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized3.test1();
            }
        });
        thread3.start();
        thread4.start();

        /**
         * 这里调用了test3方法和test4方法，但是他们都是类锁，故，就算是多个对象，但是类在JVM就一份，在JVM中存在方法区，线程共享，故不管多少个对象，都需要获取该类的类锁，
         * 输出结果也可以直观看到，确实故另一个线程必须等待
         * 总结：多个对象，类锁之间的比较，互相影响
         * */
        TestSynchronized testSynchronized4 = new TestSynchronized();
        Thread thread5 =  new Thread(new Runnable() {
            @Override
            public void run() {
                TestSynchronized.test3();
            }
        });
        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized4.test4();
            }
        });
        thread5.start();
        thread6.start();

        /**
         * 这里调用了test3类锁和test2对象锁。发现互不干扰
         * 备注：类锁和对象锁是两个不一样的锁，互不干扰，可以同时获得
         * */
        TestSynchronized testSynchronized5 = new TestSynchronized();
        Thread thread7 =  new Thread(new Runnable() {
            @Override
            public void run() {
                TestSynchronized.test3();
            }
        });
        Thread thread8 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized5.test2();
            }
        });
        thread7.start();
        thread8.start();
    }
}
