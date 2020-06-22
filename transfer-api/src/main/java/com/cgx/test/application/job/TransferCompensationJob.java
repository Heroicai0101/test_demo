package com.cgx.test.application.job;

import com.cgx.test.common.util.GsonUtil;
import com.cgx.test.domain.model.TransferEvent;
import com.cgx.test.domain.model.TransferFlowStateEnum;
import com.cgx.test.infrastructure.mq.TransferFlowMQProducer;
import com.cgx.test.infrastructure.persistence.demo.mapper.TransferFlowMapper;
import com.cgx.test.infrastructure.persistence.demo.model.TransferFlowDO;
import com.cgx.test.infrastructure.persistence.demo.model.TransferFlowDOExample;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 转账补偿任务: 拉取未处理的消息(state=0)重新进行投递，投递成功后更新为已处理(state=1)
 */
@Slf4j
@Service
public class TransferCompensationJob {

    @Resource
    private TransferFlowMQProducer transferMsgProducer;

    @Resource
    private TransferFlowMapper transferFlowMapper;

    /**
     * TODO 用分布式任务调度框架替代
     */
    @Scheduled(cron = "0 0/2 * * * ?")
    public void startJob() {
        Date yesterday = new DateTime().withTimeAtStartOfDay().minusDays(1).toDate();
        TransferFlowDOExample example = new TransferFlowDOExample();
        example.createCriteria()
               .andStateEqualTo((byte) TransferFlowStateEnum.TODO.getStateCode())
               .andGmtCreatedGreaterThan(yesterday);

        List<TransferFlowDO> transferFlows = transferFlowMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(transferFlows)) {
            log.info("Do nothing");
            return;
        }

        for (TransferFlowDO flow : transferFlows) {
            TransferEvent event = new TransferEvent();
            event.setTransactionNo(flow.getTransactionNo());
            event.setSelfUserId(flow.getSelfUserId());
            event.setOppositeUserId(flow.getOppositeUserId());

            try {
                boolean success = transferMsgProducer.sendMsg(event);
                if (success) {
                    transferFlowMapper.updateState(flow.getTransactionNo(), TransferFlowStateEnum.DONE.getStateCode());
                }
            } catch (Exception e) {
                log.error("compensation_job_exception||msg={}", GsonUtil.toJson(flow));
            }
        }
    }

}
