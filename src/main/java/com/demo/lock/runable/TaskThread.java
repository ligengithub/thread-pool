package com.demo.lock.runable;

import com.demo.lock.lock_demo.ShareLockDemo;

/**
 * @author ligen
 * @title: TaskThread
 * @projectName thread-pool
 * @description:
 * @date 2019/7/914:47
 */
public class TaskThread implements Runnable {

   final ShareLockDemo shareLock = new ShareLockDemo();
    @Override
    public void run() {
//        while (true) {

            try {
//                System.out.println("即将加锁，线程"+Thread.currentThread().getName());
                shareLock.lock();
                System.out.println("加锁完成，线程"+Thread.currentThread().getName());
                System.out.println("测试共享锁中，我是线程" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//                System.out.println("即将解锁，线程"+Thread.currentThread().getName());
                shareLock.unlock();
                System.out.println("解锁完成，线程"+Thread.currentThread().getName());

            }
//        }
    }
}
