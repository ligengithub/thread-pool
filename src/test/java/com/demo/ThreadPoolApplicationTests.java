package com.demo;

import com.demo.async.AsyncWork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolApplicationTests {

    @Autowired
    AsyncWork asyncWork;


    @Test
    public void contextLoads() {
    }





    @org.junit.Test
    public void asyncMethodWithVoidReturnType() throws InterruptedException {
        asyncWork.task1();
        asyncWork.task2();
        Thread.currentThread().join();
    }

}
