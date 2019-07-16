package com.demo.lock.main;


import com.demo.lock.runable.Job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ligen
 * @title: ReentrantLockTestMain
 * @projectName thread-pool
 * @description:   非公平锁和公平锁      ReentrantLock  是可重入锁，在当前线程释放锁之前任然可以重复加锁
 * @date 2019/7/916:39
 */
public class ReentrantLockTestMain {


    // 公平锁
    private static ReentrantLockDemo fireLock = new ReentrantLockDemo(true);
    // 非公平锁
    private static ReentrantLockDemo unfileLock = new ReentrantLockDemo(false);


    public static void main(String[] args) throws InterruptedException {

        Job job = new Job(unfileLock);
//        Job job = new Job(fireLock);

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(job, "thread-" + i);
            thread.start();

        }
        Thread.sleep(20000);

    }


    // 这里定义一个锁继承自 可重入锁
    public static class ReentrantLockDemo extends ReentrantLock {
        public ReentrantLockDemo(boolean fair) {
            super(fair);
        }
        public ReentrantLockDemo(){
            super();
        }

              public List<Thread> getQueueThreads() {
                List<Thread> list = new ArrayList<>(super.getQueuedThreads());
                Collections.reverse(list);
                return list;

        }

    }
}



