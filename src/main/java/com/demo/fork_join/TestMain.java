package com.demo.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @author ligen
 * @title: TestMain
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1218:06
 */
public class TestMain {
    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long bedin = System.nanoTime();
        // 生成一个计算任务
        ForkJoin forkJoin = new ForkJoin(1, 3000000);
        // 执行
        Future<Integer> result = forkJoinPool.submit(forkJoin);
        // Long end = System.nanoTime();
        try {
            System.out.println(result.get());
            Long end = System.nanoTime();
            System.out.println("用时" + (end - bedin) + "ns");
        } catch (Exception e) {
        }
    }


}
