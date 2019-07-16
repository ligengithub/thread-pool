package com.demo.testmain;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author ligen
 * @title: MultiThread
 * @projectName thread-pool
 * @description:
 * @date 2019/7/816:32
 */
public class MultiThread {
    /**
     * @ desc : 通过JMX 查看哪些一个java程序有哪些 线程
     * @ params
     * @ return
     * @ date 2019/7/8
     */

    public static void main(String[] args) {

        // 获取java线程管理的mxbean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // monitor 和 synchronizers 信息是否获取   此处只获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
                    getThreadName());
        }


/*       结果
        [6]Monitor Ctrl -Break
        [5] Attach Listener
        [4]Signal Dispatcher
        [3]Finalizer
        [2] Reference Handler
        [1]main
        */


    }
}
