package Subject_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wz on 2019/5/27.
 */
public class LockTest {
    private Lock lock = new ReentrantLock();
    public static void main(String[] args)  {
        LockTest LockTest = new LockTest();
        MyThread thread1 = new MyThread(LockTest,"A");
        MyThread thread2 = new MyThread(LockTest,"B");
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException{
        //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将 InterruptedException 抛出
        lock.lockInterruptibly();
        try {
            System.out.println("线程 " + thread.getName()+"得到了锁...");
            long startTime = System.currentTimeMillis();
            for(    ;     ;) {              // 耗时操作
                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
                //插入数据
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"执行finally...");
            lock.unlock();
            System.out.println("线程 " + thread.getName()+"释放了锁");
        }
        System.out.println("over");
    }
}

class MyThread extends Thread {
    private Subject_demo.LockTest LockTest = null;

    public MyThread(Subject_demo.LockTest LockTest, String name) {
        super(name);
        this.LockTest = LockTest;
    }

    @Override
    public void run() {
        try {
            LockTest.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println("线程 " + Thread.currentThread().getName() + "被中断...");
        }
    }
}

