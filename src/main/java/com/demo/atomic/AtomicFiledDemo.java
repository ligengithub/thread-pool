package com.demo.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ligen
 * @title: AtomicFiledDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1511:55
 */
public class AtomicFiledDemo {

    /*
    * 有以下三个类（更新某个类的某个字段）
    * AtomicIntegerFiledUpdater  原子跟新整形字段的更新器
    * AtomicLongFieldUpdater     原子更新长整形字段的更新器
    * AtomicStampedReference     原子更新带有版本号的引用类型 该类将整数值与引用类型关联起来，可用于版本号的管理
    * 可防止CAS时候出现的ABA问题 ，即cas 检查的是被其它线程修改了两次，修改回预期值
    *
    *
    * */
   private static AtomicIntegerFieldUpdater<People> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(People.class,"age");


    public static void main(String[] args) {
        People zhangsan = new People(20,"zhangsan");
        System.out.println(zhangsan.toString());
        fieldUpdater.incrementAndGet(zhangsan);
        System.out.println(zhangsan.toString());


    }
}
