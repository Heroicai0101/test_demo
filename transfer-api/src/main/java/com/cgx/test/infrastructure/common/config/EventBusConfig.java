package com.cgx.test.infrastructure.common.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class EventBusConfig {

    @Bean(name = "transferEventBus")
    @ConditionalOnMissingBean(name = "transferEventBus")
    public EventBus transferEventBus() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setQueueCapacity(1024);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setThreadNamePrefix("transfer-");
        taskExecutor.initialize();
        return new AsyncEventBus("transferEventBus", taskExecutor);
    }

}