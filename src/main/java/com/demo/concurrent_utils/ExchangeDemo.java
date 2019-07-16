package com.demo.concurrent_utils;

import ch.qos.logback.core.util.TimeUtil;

import javax.annotation.security.RunAs;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author ligen
 * @title: ExchangeDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1515:28
 */
public class ExchangeDemo {

    private static final Exchanger<String> exchange = new Exchanger<>();


    public static void main(String[] args) throws InterruptedException {

        JobA jobA = new JobA();
        JobB jobB = new JobB();
        JobC jobC = new JobC();
        JobD jobD = new JobD();

        Thread thread1 = new Thread(jobA, "jobA");
        Thread thread2 = new Thread(jobB, "jobB");
        Thread thread3 = new Thread(jobC, "jobC");
        Thread thread4 = new Thread(jobD, "jobD");
        thread1.start();
        thread4.start();
//        thread3.start();
        thread2.start();

        // 如果奇数个线程进行数据交换，没有交换对象的会阻塞
        System.out.println("主线程程序");
    }


    static class JobA implements Runnable {

        @Override
        public void run() {
            String dataA = "dataA";

            System.out.println("我是线程---" + Thread.currentThread().getName());
            try {
                System.out.println("jobA 拿到了--" + exchange.exchange(dataA));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class JobB implements Runnable {

        @Override
        public void run() {
            String dataB = "dataB";
            System.out.println("我是线程---" + Thread.currentThread().getName());
            try {
//                exchange.exchange(dataB)
                System.out.println("jobB 拿到了--" + exchange.exchange(dataB,5, TimeUnit.SECONDS));
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    static class JobC implements Runnable {

        @Override
        public void run() {
            String dataC = "dataC";
            System.out.println("我是线程---" + Thread.currentThread().getName());
            try {
//                exchange.exchange(dataB)
                System.out.println("jobC 拿到了--" + exchange.exchange(dataC));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class JobD implements Runnable {

        @Override
        public void run() {
            String dataD = "dataD";
            System.out.println("我是线程---" + Thread.currentThread().getName());
            try {
//                exchange.exchange(dataB)
                System.out.println("jobC 拿到了--" + exchange.exchange(dataD));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
