package com.demo.concurrent_utils;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.concurrent.Semaphore;

/**
 * @author ligen
 * @title: SemaphoreDemo
 * @projectName thread-pool
 * @description: 信号量（控制并发的线程数量）
 * <p>
 * 举个例子 ： 从硬盘上读取很多文件，，我们可以开40个线程去读取。。
 * 然后要将数据存储到数据库 ，数据库连接池的大小只有10
 * 这四十个同时写会报数据库连接失败的错误，使用Semaphore 来控制，这四十个线程中，只有10个可以并发的执行。
 * @date 2019/7/1514:57
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        Task task = new Task();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(task, "task-" + i);
            thread.start();
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {

            // 此处不需要控制线程数量的逻辑处理
            System.out.println("读取完成  准备写入--我是Thread---" + Thread.currentThread().getName());
            try {
                semaphore.acquire();   // 获取许可证
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  此处写需要控制线程数量的逻辑处理
            System.out.println("写入中---我是Thread---" + Thread.currentThread().getName());
            semaphore.release();      // 释放许可证
        }
    }

}
