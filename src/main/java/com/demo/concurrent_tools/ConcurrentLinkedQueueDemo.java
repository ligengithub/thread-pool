package com.demo.concurrent_tools;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author ligen
 * @title: ConcuurentLinkedQueue
 * @projectName thread-pool
 * @description: 无界非阻塞 线程安全
 * <p>
 * 分两类    1 非阻塞  ConcurrentLinkedQueueDemo 无界，非阻塞
 * 2  阻塞   BlockQueue 接口下的实现类
 * <p>
 * BlockQueue 有以下实现类  阻塞队列
 * <p>
 * - ArrayBlockingQueue()  数组结构 有界阻塞队列
 * - LinkedBlockingQueue  链表结构  有界阻塞
 * - PriorityBlockingQueue  支持优先级无界阻塞
 * - DelayQueue 使用优先级队列实现的无界阻塞
 * - SyncchronousQueue 一个不存储元素的阻塞队列   // 等价于队列长度为1
 * - LinkedTransferQueue 链表结构无界阻塞
 * - LinkedBlockingDeque 链表结构双向阻塞
 * @date 2019/7/1216:01
 */
public class ConcurrentLinkedQueueDemo {

    static ConcurrentLinkedQueue<String> safeQueue = new ConcurrentLinkedQueue<>();

    static SynchronousQueue<String> syncQueue = new SynchronousQueue<>();


    public static void main(String[] args) {

        PutTask putTask = new PutTask();
        GetTask getTask = new GetTask();

        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(putTask, "put-thread-" + i);
            thread.start();
        }

        Thread thread = new Thread(getTask, "get-thred");
        thread.start();

    }


    //  入队任务
    static class PutTask implements Runnable {

        @Override
        public void run() {
            Integer cnt = 0;
            while (true) {
                try {
                    Thread.sleep(300);
                    //                safeQueue.add(cnt + "--------" + Thread.currentThread().getName());   //ConcurrentLinkedQueue
                    syncQueue.put(cnt + "--------" + Thread.currentThread().getName()); // SyncchronousQueue
                    System.out.println("入队列------" + Thread.currentThread().getName() + "------------" + cnt);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cnt++;

            }
        }
    }

    // 出队任务
    static class GetTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                String res = (String) safeQueue.poll();  // ConcurrentLinkedQueue
                String res = null;  // ConcurrentLinkedQueue
                try {
                    res = (String) syncQueue.take();  // SyncchronousQueue
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("出队列------------" + res);
            }

        }
    }


}
