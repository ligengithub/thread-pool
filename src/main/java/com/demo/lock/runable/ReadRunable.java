package com.demo.lock.runable;

import com.demo.lock.main.ReentrantReadWriteLockTest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ligen
 * @title: ReadRunable
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1010:27
 */
public class ReadRunable implements Runnable{
    private static ReentrantReadWriteLock.ReadLock readLock =  ReentrantReadWriteLockTest.readLock;


    @Override
    public void run() {
        while (true){

            try {
                readLock.lock();
                System.out.println(">------>>>>>-------->>>>加读锁>------>>>>>-------->>>>,当前线程为"+Thread.currentThread().getName());
                System.out.println("******read******,我是---"+Thread.currentThread().getName()+"data的结果为-------");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("<<<<-----<<<<<解读锁<<<<<-------<<<<<*，当前线程为"+Thread.currentThread().getName());    // 写前面与写后面的区别  写在后面可能会出现先打印  下一条线程thread 上锁，然后打印本条解锁  造成一种视觉错觉
                readLock.unlock();
            }

        }


    }
}
