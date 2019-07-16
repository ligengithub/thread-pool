package com.demo.lock.main;

import com.demo.lock.lock_demo.MutexLockDemo;

/**
 * @author ligen
 * @title: MutexTestMain
 * @projectName thread-pool
 * @description:
 * @date 2019/7/915:36
 */
public class MutexTestMain {

    public static void main(String[] args) throws InterruptedException {
        MutexRunable mutexRunable = new MutexRunable();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(mutexRunable, "thread-" + i);
            thread.start();

        }
         Thread.sleep(20000);
    }



    static class MutexRunable implements Runnable {

        MutexLockDemo mutexLock = new MutexLockDemo();

        @Override
        public void run() {


            try {
                mutexLock.lock();
                System.out.println("加锁完成,我是线程" + Thread.currentThread().getName());
//                mutexLock.lock();  //  不可重入锁  在这里会堵塞
                System.out.println("独占式锁测试,我是线程" + Thread.currentThread().getName());
//                mutexLock.unlock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutexLock.unlock();
                System.out.println("解锁完成，我是线程" + Thread.currentThread().getName());
            }


        }
    }

}
