package com.demo.testmain;


import org.springframework.stereotype.Component;


/**
 * @author ligen
 * @title: ShareTestMain
 * @projectName thread-pool
 * @description:
 * @date 2019/7/810:26
 */
@Component
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Mythread();
        thread.start();

        while (true){
            System.out.println("----------我是主线程----------"+Thread.currentThread().getName());
            Thread.sleep(1000);

        }

    }

}
