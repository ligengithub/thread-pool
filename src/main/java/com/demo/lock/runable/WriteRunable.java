package com.demo.lock.runable;

import com.demo.lock.main.ReentrantReadWriteLockTest;
import org.springframework.util.StringUtils;

import javax.xml.stream.events.Characters;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ligen
 * @title: ReadRunable
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1010:27
 */
public class WriteRunable implements Runnable {
    private static ReentrantReadWriteLock.WriteLock writeLock = ReentrantReadWriteLockTest.writeLock;
    private static ReentrantReadWriteLock.ReadLock readLock = ReentrantReadWriteLockTest.readLock;

    @Override
    public void run() {
        while (true) {
            try {
                writeLock.lock();    //1 加写锁
                System.out.println(">------>>>>>-------->>>>加写锁>------>>>>>-------->>>>加锁完成,当前线程为" + Thread.currentThread().getName());

                Thread.sleep(3000);
                System.out.println("---------write--------,我是-------------------------------------------------------------------------" + Thread.currentThread().getName());

                // 此处写更新数据的业务逻辑 3

                System.out.println("------------->>>>>-------->>>>加读锁>------>>>>>-------->>>>加锁完成");
                readLock.lock();    //2 加读锁
                System.out.println("--------<<<<-----<<<<<解写锁<<<<<-------<<<<<------------<<<<---------");

                // 从此刻开始 其它的读线程可以加读锁读取数据  因而提高了并发      但是，读锁并没有释放，所以其它的线程不能加写锁，因而保证了数据安全，，后面的业务逻辑5处，保证了数据不会被其它线程更新
                writeLock.unlock();  // 4 解写锁，，

                //....... 此处业务逻辑  5

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("<<<<-----<<<<<解读锁<<<<<-------<<<<<释放------------<<<<，当前线程为" + Thread.currentThread().getName());
                readLock.unlock();// 6 解读锁

            }
        }


    }
}
