package com.cgx.test.infrastructure.mq;

import com.cgx.test.domain.model.TransferEvent;
import com.google.common.eventbus.EventBus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TransferFlowMQProducer {

    @Resource(name = "transferEventBus")
    private EventBus eventBus;

    /**
     * TODO 替换为如RocketMQ、Kafka等消息组件
     */
    public boolean sendMsg(TransferEvent event) {
        eventBus.post(event);
        return true;
    }

}
