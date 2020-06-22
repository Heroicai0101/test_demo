package com.cgx.test.application.service;

import com.cgx.test.common.util.GsonUtil;
import com.cgx.test.domain.model.TransferEvent;
import com.cgx.test.domain.model.TransferFlowStateEnum;
import com.cgx.test.infrastructure.mq.TransferFlowMQProducer;
import com.cgx.test.infrastructure.persistence.demo.mapper.TransferFlowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.annotation.Resource;

@Slf4j
@Service
public class TransferEventAppService {

    @Resource
    private TransferFlowMQProducer transferFlowMQProducer;

    @Resource
    private TransferFlowMapper transferFlowMapper;

    /**
     * TransactionPhase.AFTER_COMMIT 保证了事务提交后监听者才能收到事件
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleEvent(TransferEvent event) {
        try {
            // 发送MQ消息
            boolean success = transferFlowMQProducer.sendMsg(event);
            if (success) {
                // 更新本地消息表的状态为已处理
                transferFlowMapper.updateState(event.getTransactionNo(), TransferFlowStateEnum.DONE.getStateCode());
            }
        } catch (Exception e) {
            log.error("handle_transfer_event_error||msg={}", GsonUtil.toJson(event));
        }
    }

}
