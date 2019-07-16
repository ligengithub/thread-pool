package com.demo.lock.runable;


import com.demo.lock.main.ReentrantLockTestMain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ligen
 * @title: Job
 * @projectName thread-pool
 * @description:
 * @date 2019/7/916:53
 */
public class Job implements Runnable {
    private ReentrantLockTestMain.ReentrantLockDemo lock;

    public Job(ReentrantLockTestMain.ReentrantLockDemo lock) {
        this.lock = lock;
//        lock.getQueueThreads()

    }

    @Override
    public void run() {
        while (true) {     // 演示非公平锁和公平锁   加whileTrue  不要让线程死掉，才可重入
            try {
                lock.lock();
                Thread.sleep(1000);
                System.out.println("当前的线程的名字是" + Thread.currentThread().getName());
                System.out.println(lock.getQueueThreads());

                //  可重入
//                lock.lock();   // 可重入  不会阻塞
                  System.out.println("--------------------重入--------------------");
//                System.out.println("当前的线程的名字是" + Thread.currentThread().getName());
//                System.out.println(lock.getQueueThreads());
//                lock.unlock();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
