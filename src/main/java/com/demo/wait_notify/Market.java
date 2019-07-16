package com.demo.wait_notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ligen
 * @title: Market
 * @projectName thread-pool
 * @description:
 * @date 2019/7/816:55
 */
public class Market implements Runnable {


    String lock = MainTest.lock;

    @Override
    public void run() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        while (true) {
        synchronized (lock) {
                while (MainTest.flag == false) {
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            try {
                Thread.sleep(1000);
                Product product = new Product("苹果", 15);
                MainTest.queue.add(product);
                logger.info("生产一个苹果，现在有" + MainTest.queue.size());
                if (MainTest.queue.size()>15){
                    System.out.println("苹果到15个了我要休息");
                    MainTest.flag=false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        }


    }
}
