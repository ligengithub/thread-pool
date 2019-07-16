package com.demo.lock.main;

import ch.qos.logback.core.util.TimeUtil;
import com.demo.lock.runable.ReadRunable;
import com.demo.lock.runable.WriteRunable;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ligen
 * @title: ReentrantReadWriteLock
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1010:24
 */
public class ReentrantReadWriteLockTest {
 public static ReentrantReadWriteLock  readwriteLock = new ReentrantReadWriteLock(false); //  true  公平锁    false 非公平锁

 public static ReentrantReadWriteLock.ReadLock readLock = readwriteLock.readLock();
 public static ReentrantReadWriteLock.WriteLock writeLock = readwriteLock.writeLock();

 public static volatile String data =null;


    public static void main(String[] args) {


        ReadRunable read = new ReadRunable();
        WriteRunable write = new WriteRunable();


        for (int i = 0; i < 1; i++) {
            Thread writeThread = new Thread(write,"write-"+i);
            writeThread.start();
            Thread readThread = new Thread(read,"read-"+i);
            readThread.start();
        }
    }



}
