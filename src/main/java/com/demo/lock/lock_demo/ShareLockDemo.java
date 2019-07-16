package com.demo.lock.lock_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ligen
 * @title: ShareLockDemo
 * @projectName thread-pool
 * @description:   这是一个共享锁的demo
 * @date 2019/7/914:19
 */
public class ShareLockDemo implements Lock {

    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must largethan zero.");
            }
            setState(count);
        }
        public int tryAcquireShared(int reduceCount) {
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current,
                        newCount)) {
//                    System.out.println("获取锁失败");
                    return newCount;
                }
            }
        }
        public boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
//                    System.out.println("释放锁成功");
                    return true;
                }else {
//                    System.out.println("释放锁失败，重试中");
                }
            }
        }
    }
//    private static Sync sync = new Sync(2);
//
//    // 同步器
//    private static class Sync extends AbstractQueuedSynchronizer {
//
//        // 同步器构造方法
//        Sync(int count) {
//            if (count <= 0) {
//                throw new IllegalArgumentException("count must > 0");
//            }
//            setState(count);
//        }
//
//        @Override
//        protected int tryAcquireShared(int reduceCount) {
//            for (; ; ) {
//                //  获取同步器状态
//                int current = getState();
//                int newCount = current - reduceCount;   // 获取一个  可用的-1
//                if (newCount < 0 || compareAndSetState(current,
//                        newCount)) {
//                    return newCount;   //可用的小于0的话 直接返回，表示获取锁失败
//                }
//                // 如果可用的大于0 表示获取成功，，阻塞在这里线程执行，，等待释放锁
//            }
//        }
//
//        @Override
//        protected boolean tryReleaseShared(int returnCount) {
//            for (; ; ) {
//                // 释放同步器状态
//                int current = getState();
//                int newCount = current + returnCount;   // 释放一个 可用的+1
//                if (compareAndSetState(current, newCount)) {
//                    return true;
//                }
//            }
//
//        }
//
//        @Override
//        protected boolean isHeldExclusively() {
//            return getState() >= 0;
//        }
//
//
//        Condition newCondition() {
//
//            return new ConditionObject();
//        }
//    }


    // lock的方法的重写
    @Override
    public void lock() {
        sync.acquireShared(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        if (sync.tryAcquireShared(1) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);

    }

    @Override
    public Condition newCondition() {
        return null;
    }

//    @Override
//    public Condition newCondition() {
//        return sync.newCondition();
//    }
}
