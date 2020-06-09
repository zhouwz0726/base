package base.thread.concurrent;


import java.util.concurrent.CyclicBarrier;

/**
 * cyclicBarrier:栅栏,是一个同步机制，使得一系列算法实现同步
 * cyclicBarrier:让一组线程到达一个屏障（同步点）时阻塞，直到最后一个线程到达后，才会释放这个屏障;
 * cyclicBarrier默认的构造方法里面的参数，表示当前栅栏的线程数量，每个线程调用await方法告诉cyclicBarrier我已经到达屏障，然后当线程被阻塞
 * 例子：当下面线程1和线程2都调用awit方法后，cyclicBarrier的线程数量设置为2，达到了设置的数量，然后就会执行输出语句
 * 当然static CyclicBarrier c = new CyclicBarrier(2, new A());参数new A代表了，当达到屏障数量后，可以优先执行new A
 * @author zhouwz
 * */
public class CyclicBarrierDemo {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {

        //线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    System.out.println("当前运行线程为：" + Thread.currentThread().getName());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    System.out.println("当前运行线程为：" + Thread.currentThread().getName());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
