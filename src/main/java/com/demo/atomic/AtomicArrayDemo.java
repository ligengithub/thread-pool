package com.demo.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author ligen
 * @title: AtomicArrayDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1511:22
 */
public class AtomicArrayDemo {
    /*
     *  四个类
     * AtomicIntegerArray 原子更新整形数组里面的元素
     * AtomicLongArray  原子更新长整形数组里面的元素
     * AtomicReferenceArray 原子更新引用数组里面的元素
     * AtomicIntegerArray 原子的方式更新数组的整形
     *
     * 常用方法
     * int addAndGet(int i,int delta)
     * boolean compareAndSet(int i,int expect,int update)
     * */

    public static void main(String[] args) {
        AtomicIntegerArray integerArray = new AtomicIntegerArray('5');

        System.out.println(integerArray.get(0));
        System.out.println(integerArray.addAndGet(0,1));  //与1 相加返回之后的值
        System.out.println(integerArray.compareAndSet(0,1,2));  // 与预期相符合 返回truw
        System.out.println(integerArray.get(0));   // 返回更新后的值   2
    }


}
