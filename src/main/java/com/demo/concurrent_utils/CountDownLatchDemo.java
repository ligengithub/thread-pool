package com.demo.concurrent_utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author ligen
 * @title: CountDownLatchDemo
 * @projectName thread-pool
 * @description: 允许一个或多个线程等待其它线程完成操作
 * @date 2019/7/1513:35
 */
public class CountDownLatchDemo {
    /*
    * 传统的让当前线程等待其它线程执行完使用join
    * join的工作原理是，不停的去查询线程是否存活，如果其它线程存活，则让当前线程永远等待wait(0), 其它线程结束以后 使用notifyAll 因为notifyAll 封装再JVM里面，所以看不到
    *
    * CountDownLatch  用法
    * 1  在构造函数中写入参数，表明需要几个点完成
    *
    * 2 在线程任务完成以后 调用 countDown() 方法 来使   -1
    *
    * 3 在执行等待的线程中调用 await() 方法。等待 点变成 0
    *
    * */
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println("3");
    }


}
