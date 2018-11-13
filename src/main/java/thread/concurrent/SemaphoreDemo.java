package thread.concurrent;


import java.util.concurrent.Semaphore;

/**
 * semaphore:计数信号量，主要2个方法，acquire()，获取一个许可;release()，吧当前的许可返回给信号量
 * 例子:6个人需要进入停车场，然后停车就3个位置，一开始进去3个后，后面必须等前面的人出来（释放）才可以进去
 * semaphore，没有办法保证线程能够公平地可从信号量中获得许可。
 * 也就是说，无法担保掉第一个调用 acquire() 的线程会是第一个获得一个许可的线程。如果第一个线程在等待一个许可时发生阻塞，而第二个线程前来索要一个许可的时候刚好有一个许可被释放出来，那么它就可能会在第一个线程之前获得许可。
 * 如果你想要强制公平，Semaphore 类有一个具有一个布尔类型的参数的构造子，通过这个参数以告知 Semaphore 是否要强制公平。强制公平会影响到并发性能，所以除非你确实需要它否则不要启用它。
 * @author zhouwz
 * */
public class SemaphoreDemo extends Thread {

    private static final Semaphore semaphore = new Semaphore(3,true);

        private String name ;

        public SemaphoreDemo(String name){
            this.name = name;
        }

        public void run(){
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "大家好：我是" + name);
                Thread.sleep(1000);
                System.out.println(name+"要准备释放许可证了，当前时间为："+System.currentTimeMillis());
                System.out.println("当前可使用的许可数为："+semaphore.availablePermits());
                semaphore.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    public static void main(String[] args) {
        String nameArr[] = {"张三","李四","王五","周六","戚七","陶八",};
        for (String n:nameArr) {
            Thread thread  = new SemaphoreDemo(n);
            thread.start();
        }
    }
}
