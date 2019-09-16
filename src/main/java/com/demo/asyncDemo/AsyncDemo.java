package com.demo.asyncDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ligen
 * @title: AsyncDemo
 * @projectName thread-pool
 * @description:
 * @date 2019/9/168:12
 */
@Component
public class AsyncDemo {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * @说明: 简单定时任务
     */
    @Async
    @Scheduled(cron = "0/3 * * * * ?")
    public void deleteCmdLog() {
        Long startTime = System.currentTimeMillis();
        logger.info("ScheduleTask 定时清除命令日志开始");
//        System.out.println("haha");
//        cmdLogService.clearLog(20);
        logger.info("ScheduleTask 定时清除命令日志结束" + "Spend Time : " + (System.currentTimeMillis() - startTime));
    }

}
