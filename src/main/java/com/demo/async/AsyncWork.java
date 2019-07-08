package com.demo.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author ligen
 * @title: AsyncWork
 * @projectName thread-pool
 * @description:
 * @date 2019/7/810:53
 */
@Component
public class AsyncWork {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Random random = new Random();



    @Async("async")
    public  void task1() throws InterruptedException {
        logger.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async("async")
    public  void task2() throws InterruptedException {
        logger.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }



}
