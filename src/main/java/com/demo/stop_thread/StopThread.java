package com.demo.stop_thread;

/**
 * @author ligen
 * @title: StopThread
 * @projectName thread-pool
 * @description:
 * @date 2019/7/819:00
 */
public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        MyRunable runable = new MyRunable();
        Thread thread = new Thread(runable, "thread-1");
        thread.start();
        Thread.sleep(1000);
        // 方法1 通过interrupt 使线程停止
        thread.interrupt();
        MyRunable runable1 = new MyRunable();
        Thread thread2 = new Thread(runable1, "thread-2");
        thread2.start();
        Thread.sleep(1000);
        thread.join();
        runable1.cancel();


    }


    static class MyRunable implements Runnable {
        long i;

        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
//                        System.out.println("22222");
                // 如果用Interrupt的方法停止线程， 不要写thread.sleep 否则可能，因为刚好要中断，但是休眠了导致异常的发生，没有办法中断
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }

            }
            System.out.println(Thread.currentThread().getName() + "将停止,执行了" + i + "次");

        }

        public void cancel() {
            this.on = false;
        }
    }


}
