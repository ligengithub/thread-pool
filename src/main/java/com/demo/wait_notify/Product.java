package com.demo.wait_notify;

/**
 * @author ligen
 * @title: Product
 * @projectName thread-pool
 * @description:
 * @date 2019/7/816:57
 */
public class Product {

    String name;
    Integer price;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "name="+this.name+
                "price="+this.price;
    }
}
