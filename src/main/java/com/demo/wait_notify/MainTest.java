package com.demo.wait_notify;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ligen
 * @title: MainTest
 * @projectName thread-pool
 * @description:
 * @date 2019/7/816:58
 */
public class MainTest {
    static String lock="lock";
    static long num = 0;
    static boolean flag = true;

    public static BlockingQueue<Object> queue = new ArrayBlockingQueue<>(20);

    public static void main(String[] args) throws InterruptedException {

        Market market = new Market();
        Thread marketT = new Thread(market,"market");
        marketT.start();

        Customer customer = new Customer();
        Thread custromT = new Thread(customer,"custrom");
        custromT.start();

        Thread custrom2T = new Thread(customer, "custrom2");
        custrom2T.start();


    }

}
