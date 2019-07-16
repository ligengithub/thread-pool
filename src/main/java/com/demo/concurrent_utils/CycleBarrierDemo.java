package com.demo.concurrent_utils;

import java.util.concurrent.CyclicBarrier;

/**
 * @author ligen
 * @title: CycleBarrierDemo
 * @projectName thread-pool
 * @description: 同步屏障
 * 让一组线程设置一个屏障 （也叫同步点） 当每个线程到达屏障将会被阻塞，，所有的线程全部到达屏障才会打开
 * <p>
 * <p>
 * 使用方法 构造函数的参数，指明拦截的线程数量
 * <p>
 * 线程任务中使用await() 来告诉屏障 我已经到达了屏障，并开始阻塞
 * <p>
 * 等待线程中使也需要用await() 来阻塞等待其它线程执行玩。
 * <p>
 * CycleBarrier和CountDownLatch 区别
 * <p>
 * CountLatch 只能执行一次
 * <p>
 * CycleBarrier 可以通过reset方法置0 执行多次
 * （就像 车站 来20个人 发一车，，然后reset 置零 来20个再发一车。。。 而CountDownLatch 只执行一次）
 * @date 2019/7/1513:51
 */
public class CycleBarrierDemo {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);  // 参数设置 点

    // 高级用法，所有线程到达先执行methodFlag
    static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(4, new MethodFlag());

    public static void main(String[] args) {

//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                try {
//                    System.out.println("我是线程--" + Thread.currentThread().getName());
//                    cyclicBarrier.await();
//                } catch (Exception e) {
//                    System.out.println(e.toString());
//                }
//            }).start();
//        }
//        try {
//            System.out.println("我是线程--" + Thread.currentThread().getName());
//            cyclicBarrier.await();
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        System.out.println("线程执行完毕");


        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println("我是线程--" + Thread.currentThread().getName());
                    cyclicBarrier2.await();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }).start();
        }
        try {
            System.out.println("我是线程--" + Thread.currentThread().getName()); // main 线程
            cyclicBarrier2.await();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        // 线程已经到齐了，，会去优先执行构造参数里面的方法

        System.out.println("线程执行完毕");

        System.out.println("-------------------------下面是第二轮--------------------------------");

        // 下面体现重复使用
        cyclicBarrier2.reset();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println("我是线程--" + Thread.currentThread().getName());
                    cyclicBarrier2.await();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }).start();
        }
        try {
            System.out.println("我是线程--" + Thread.currentThread().getName()); // main 线程
            cyclicBarrier2.await();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        // 线程已经到齐了，，会去优先执行构造参数里面的方法

        System.out.println("线程第二轮执行完毕");


    }


    static class MethodFlag implements Runnable {

        @Override
        public void run() {
            System.out.println("所有线程已经到齐了 我是优先执行方法");
        }
    }


}
