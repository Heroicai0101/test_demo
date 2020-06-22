package com.cgx.test.application.consumer;

import com.cgx.test.common.util.GsonUtil;
import com.cgx.test.domain.model.TransferEvent;
import com.cgx.test.infrastructure.persistence.demo.mapper.TransferEventMapper;
import com.cgx.test.infrastructure.persistence.demo.model.TransferEventDO;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class TransferEventListener {

    @Resource(name = "transferEventBus")
    private EventBus transferEventBus;

    @Resource
    private TransferEventMapper transferEventMapper;

    @Resource
    private TransferMsgProcess transferMsgProcess;

    @PostConstruct
    public void init() {
        transferEventBus.register(this);
    }

    /**
     * 模拟mq的消费者
     * 1.先将消息存储下来
     * 2.再开启本地事务消费消息，消费成功后删除消息
     * TODO 消费异常了又需要补偿任务，略。。。
     */
    @Subscribe
    public void onEvent(TransferEvent event) {
        log.info("received_msg||event={}", GsonUtil.toJson(event));

        TransferEventDO eventDO = new TransferEventDO();
        eventDO.setTransactionNo(event.getTransactionNo());
        eventDO.setSelfUserId(event.getSelfUserId());
        eventDO.setOppositeUserId(event.getOppositeUserId());
        eventDO.setAmount(event.getAmount());
        Date now = new Date();
        eventDO.setGmtCreated(now);
        eventDO.setGmtModified(now);

        // 防重复消费消息
        try {
            transferEventMapper.insert(eventDO);
        } catch (DuplicateKeyException e) {
            log.warn("重复消息||msg={}", GsonUtil.toJson(eventDO));
            return;
        }

        transferMsgProcess.increaseMoney(event);
    }

}
