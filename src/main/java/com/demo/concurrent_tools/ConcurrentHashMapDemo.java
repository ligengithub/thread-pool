package com.demo.concurrent_tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ligen
 * @title: ConcurrentHashMap
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1213:52
 */
public class ConcurrentHashMapDemo {

//   static ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();  // 线程安全
static Map<Integer,Integer> map = new HashMap<>(150);             // 线程不安全
//   static Integer cnt=0;


    public static void main(String[] args) throws InterruptedException {

        Task  task = new Task();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task,"thread-"+i);
            thread.start();
        }
        Thread.sleep(3000);
        System.out.println("map的大小为"+map.size());

        for (int i = 1; i < map.size(); i++) {
            if (Objects.equals(i,map.get(i))){
                System.out.println(i+"---"+map.get(i));
            }else {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxx"+i+map.get(i));
            }
        }




    }


    static  class Task implements  Runnable {

        @Override
        public void run() {
            Integer cnt=0;

            while (cnt<1000){
                synchronized (this){
                    cnt++;
                }
                map.put(cnt,cnt);

            }

        }
    }


}
