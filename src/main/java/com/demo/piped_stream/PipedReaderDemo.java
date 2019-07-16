package com.demo.piped_stream;

import java.io.IOException;

/**
 * @author ligen
 * @title: PipedReaderDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/7/99:31
 */
public class PipedReaderDemo implements Runnable {
    @Override
    public void run() {
        // 从管道流中读取 并 输出到控制台
        int result;
        try {
            while ((result = PipedWriterDemo.pipedReader.read())!=-1)
            {
                System.out.print((char)result);
//                System.out.print("管道接收到的字符流为"+(char)result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
