package com.demo.ExceptionManage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @author ligen
 * @title: AsyncException
 * @projectName thread-pool
 * @description:
 * @date 2019/7/810:21
 */
public class AsyncException implements AsyncUncaughtExceptionHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        logger.info(">>>>>>>>>>线程池异常>>>>>>>>");
        logger.info(ex.toString());

    }
}
