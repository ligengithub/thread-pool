package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolApplicationTests {



    @Test
    public void contextLoads() {
    }


    @Async
    @Test
    public void TestAsync() throws InterruptedException {
        System.out.println("测试异步"+Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    @Async
    @Test
    public void TestAsync2() throws InterruptedException {
        System.out.println("测试异步"+Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    @Async
    @Test
    public void TestAsync3() throws InterruptedException {
        System.out.println("测试异步"+Thread.currentThread().getName());
        Thread.sleep(1000);
    }


}
