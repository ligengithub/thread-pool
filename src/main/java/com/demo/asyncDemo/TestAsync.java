package com.demo.asyncDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ligen
 * @title: TestAsync
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1614:01
 */
@RestController
public class TestAsync {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    @GetMapping("/test")
    public void  testAsync() throws InterruptedException {
        System.out.println("执行任务的线程是"+Thread.currentThread().getName());
        Thread.sleep(1000);
    }





}
