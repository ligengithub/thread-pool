package com.demo.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ligen
 * @title: AtomicReferenceDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1511:33
 */
public class AtomicReferenceDemo {

    /*
    * 以下三个类
    * AtomicReferenceDemo： 原子更新引用类型
    * AtomicReferenceFiledUpdater：原子更新引用类型里面的字段
    * AtomicMarkableReference ： 原子更新带有标记类型的引用类型
    *
    * */


    public static void main(String[] args) {
        AtomicReference<People> referenceDemo = new AtomicReference<>();
        People people = new People(20,"zhangsan");
        referenceDemo.set(people);   // 设置 people
        People peopleUpdate = new People(21,"zhangsan");
        boolean result = referenceDemo.compareAndSet(people,peopleUpdate);
        System.out.println(result);    // 等于预期返回true  年纪更新为21
        System.out.println(referenceDemo.get().getAge());

        result = referenceDemo.compareAndSet(people,people);
        System.out.println(result);   // 不满足，更新失败  还是21
        System.out.println(referenceDemo.get().getAge());
    }

}
