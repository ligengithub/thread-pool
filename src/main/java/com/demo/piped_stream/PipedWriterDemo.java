package com.demo.piped_stream;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author ligen
 * @title: PipedWriterDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/7/99:31
 */
public class PipedWriterDemo {
  static   PipedReader pipedReader = new PipedReader();
  static   PipedWriter pipedWriter = new PipedWriter();


    public static void main(String[] args) throws IOException {

        PipedReaderDemo pipedReaderDemo = new PipedReaderDemo();
        Thread read = new Thread(pipedReaderDemo,"read");
        read.start();
        // 将键盘的输入，添加到管道输入流
        pipedWriter.connect(pipedReader);
        int in ;

        while ((in=System.in.read())!=-1){

            System.out.print((char) in);
//            System.out.print("管道写入的字符流为"+(char)in+"我是线程"+Thread.currentThread().getName());
            pipedWriter.write(in);
        }


    }
}
