package com.demo.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author ligen
 * @title: ForkJoin
 * @projectName thread-pool
 * @description: ForkJoin   任务分解
 * Fork 任务分解
 * Join 结果合并
 * <p>
 * 只需要继承 RecursiveAction (无返回值)
 * 或者 RecursiveTask    （有返回值）
 * @date 2019/7/1217:44
 */
public class ForkJoin extends RecursiveTask {

    private static final int THRESHOLD = 2;// 阈值
    private long start;
    private long end;

    public ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
//    protected Integer compute() {
//        int sum = 0;
//// 如果任务足够小就计算任务
//        boolean canCompute = (end - start) <= THRESHOLD;
//        if (canCompute) {
//            for (int i = start; i <= end; i++) {
//                sum += i;
//            }
//        } else {
//// 如果任务大于阈值，就分裂成两个子任务计算
//            int middle = (start + end) / 2;
//            CountTask leftTask = new CountTask(start, middle);
//            CountTask rightTask = new CountTask(middle + 1, end);
//// 执行子任务
//            leftTask.fork();
//            rightTask.fork();
//// 等待子任务执行完，并得到其结果
//            int leftResult=leftTask.join();
//            int rightResult=rightTask.join();
//// 合并子任务
//            sum = leftResult + rightResult;
//        }
//        return sum;
//    }
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            System.out.println("我是线程--" + Thread.currentThread().getName());
            // 执行
            for (long i = start; i <= end; i++) {
                sum += i;
            }
//            return sum;
        } else {
            // 继续拆分   取中间  是 +
            long middle = (end + start) / 2;
            ForkJoin leftJoin = new ForkJoin(start, middle);
            ForkJoin rightJoin = new ForkJoin(middle + 1, end);
            //  执行
            leftJoin.fork();
            rightJoin.fork();
            //等待结果
            long leftResult = (long) leftJoin.join();
            long rightResult = (long) rightJoin.join();
            sum = leftResult + rightResult;
        }
        return (long) sum;
    }

}
