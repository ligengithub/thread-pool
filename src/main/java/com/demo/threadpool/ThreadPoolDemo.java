package com.demo.threadpool;

import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author ligen
 * @title: ThreadPoolDemo
 * @projectName thread-pool
 * @description: 核心线程池   核心线程池里面的线程不会被销毁
 * 等待队列     核心线程池满了以后 新来的任务会放在等待队列里面
 * 最大线程池   等待队列满了以后新的线程会先判断 最大线程池是否已满，如果已满，则交由饱和策略，反之则创建线程执行任务，执行完成以后如果没有新线程一段时间以后将被销毁
 * @date 2019/7/1517:28
 */
public class ThreadPoolDemo implements AsyncConfigurer {


    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 1, SECONDS, new ArrayBlockingQueue<>(1));


        Task task = new Task();
        Task task1 = new Task();
        Task task2 = new Task();

        /*
         * 线程任务的执行 submit 或者 execute
         * */
        executor.submit(task);
        executor.submit(task1);
        executor.execute(task2);
        /*
         * 线程池关闭
         * */
//        executor.shutdown();// 关闭线程池
//        executor.shutdownNow();// 关闭线程池，更强势一点
//        executor.isShutdown(); // 线程池是否处于关闭状态
//        executor.isTerminated(); // 线程池中所有线程是否都已经停止

        /*
        * 线程池的监控
        * */
//        executor.getTaskCount(); // 线程池需要执行的任务数量
//        executor.getCompletedTaskCount();// 已经执行的任务
//        executor.getLargestPoolSize(); // 曾经最大 （可以知道线程池是否满过）
//        executor.getPoolSize();  // 线程池的大小,只增不减？？？ > coreSize+queueSize 之后创建的线程
//        executor.getActiveCount();// 获取活动的线程数
        System.out.println("线程池曾经最大的线程数量" + executor.getLargestPoolSize());
        System.out.println(executor.getPoolSize());

        System.out.println(Runtime.getRuntime().availableProcessors()); // 获取cpu个数

    }


    // 设置任务
    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("我是线程------" + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
