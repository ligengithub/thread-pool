package com.demo.testmain;

/**
 * @author ligen
 * @title: Mythread
 * @projectName thread-pool
 * @description:
 * @date 2019/7/816:23
 */
public class Mythread extends Thread {

    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(1000);
                System.out.println("---------mythread---------"+Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
