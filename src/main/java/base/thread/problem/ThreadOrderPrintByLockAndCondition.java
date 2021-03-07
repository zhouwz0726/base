package base.thread.problem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:zhouwz
 * @date 2021-03-05 15:50
 * <p>
 * 问题：多个线程顺序循环打印ABC三个字母
 */
public class ThreadOrderPrintByLockAndCondition implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ThreadOrderPrintByLockAndCondition.class);

    private String name;

    private ReentrantLock lock;

    private Condition condition;

    /**
     * 累加计数
     */
    private static int count = 0;

    private int index;


    public ThreadOrderPrintByLockAndCondition(String name, ReentrantLock lock, Condition condition, int index){
        this.name = name;
        this.lock = lock;
        this.condition = condition;
        this.index = index;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (true){
                //除以3取余，不等于index，则让线程等待
                while (count%3 != index){
                    condition.await();
                }
                System.out.println(name);
                count++;
                if (count == 10){
                    break;
                }
                condition.signalAll();
            }
        }catch (Exception e){
            logger.error("run is error");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new Thread(new ThreadOrderPrintByLockAndCondition("A", reentrantLock, condition, 0)).start();
        new Thread(new ThreadOrderPrintByLockAndCondition("B", reentrantLock, condition, 1)).start();
        new Thread(new ThreadOrderPrintByLockAndCondition("C", reentrantLock, condition, 2)).start();

    }
}
