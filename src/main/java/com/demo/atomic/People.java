package com.demo.atomic;

/**
 * @author ligen
 * @title: People
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1511:37
 */
public class People {
    public volatile int age;
    public String name;

    public People() {
    }

    public People(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
