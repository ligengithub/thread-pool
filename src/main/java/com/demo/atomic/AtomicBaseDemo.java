package com.demo.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ligen
 * @title: AtomicBaseDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1510:27
 */
public class AtomicBaseDemo {
    public static void main(String[] args) {

        AtomicInteger atoInt = new AtomicInteger(1);
        /*
         *三个类 AtomicBoolean
         *       AtomicInteger
         *       AtomicLong
         *
         * 常用方法
         * int addAndGet(int data) 将括号里面的值与 AtomicInteger 里面的值原子性相加并返回结果
         * boolean compareAndSet(int expert,int update)   // 如果输入的等于预期的，，将该值设置为输入的值
         * int getAndIncrement()  // 以原子方式将当前值+1    返回的是+1   之前的值
         * void lazySet( int new value)   // 最终会设置成新的值，，，但是使用该方法以后，
         *                                   其它线程可能在一小段时间内读到的还是之前的值
         * int getAndSet(int new value)     //以原子方式设置为newValue的值 并返回旧值
         * int get()
         *
         * */

        //   加1 返回+1 之前的值  1
        System.out.println(atoInt.getAndIncrement());
        //    拿到当前的值      2
        System.out.println(atoInt.get());
        // cas（满足）   如果为  2 设置为4    返回true
        System.out.println(atoInt.compareAndSet(2, 4));
        //   拿到当前的值   4
        System.out.println(atoInt.get());
        //cas (不满足)    设置失败  返回false
        System.out.println(atoInt.compareAndSet(7, 5));
        //还是设置之前的值     4
        System.out.println(atoInt.get());
    }
}
