package com.demo.wait_notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ligen
 * @title: Customer
 * @projectName thread-pool
 * @description:
 * @date 2019/7/816:55
 */
public class Customer implements Runnable {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    String lock = MainTest.lock;

    @Override
    public void run() {


        while (true){
            synchronized (MainTest.lock){
                try {
                    Thread.sleep(1000);
                    MainTest.flag=true;
                    if (MainTest.queue.size()<5){
                        System.out.println("苹果不够5个了，通知开始生产,我是线程"+Thread.currentThread().getName());
                        lock.notifyAll();
                        lock.wait();
                    }else {
                        MainTest.queue.take();
                        logger.info("消费一个苹果，现在还有"+MainTest.queue.size()+"个，我是线程"+Thread.currentThread().getName());
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }




    }
}
