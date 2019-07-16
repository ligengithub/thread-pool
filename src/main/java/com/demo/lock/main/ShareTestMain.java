package com.demo.lock.main;

import com.demo.lock.runable.TaskThread;

/**
 * @author ligen
 * @title: ShareTestMain
 * @projectName thread-pool
 * @description:
 * @date 2019/7/914:41
 */
public class ShareTestMain {


    public static void main(String[] args) throws InterruptedException {

        TaskThread taskThread = new TaskThread();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(taskThread,"thread-"+i);
            thread.start();
        }
        Thread.sleep(200000);

    }



}
