package com.demo.asyncDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author ligen
 * @title: AsyncConfig
 * @projectName thread-pool
 * @description:
 * @date 2019/7/1613:47
 */
@EnableAsync
@Configuration
public class AsyncConfig {


    /**
     *@ desc :  配置线程池
     *@ params
     *@ return
     *@ date 2019/7/16
     */
    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setThreadNamePrefix("thread-pool-");
        return taskExecutor;
    }


}
