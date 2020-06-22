package com.cgx.test.domain.service;

import com.cgx.test.application.service.TransferAppEvents;
import com.cgx.test.common.exception.CustomException;
import com.cgx.test.domain.model.AssetAccount;
import com.cgx.test.domain.model.TransferEvent;
import com.cgx.test.domain.model.TransferFlowStateEnum;
import com.cgx.test.domain.repository.AccountRepository;
import com.cgx.test.domain.shard.BizStatusCode;
import com.cgx.test.infrastructure.persistence.demo.mapper.TransferFlowMapper;
import com.cgx.test.infrastructure.persistence.demo.model.TransferFlowDO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class TransferService {

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private TransferAppEvents transferAppEvents;

    @Resource
    private TransferFlowMapper transferFlowMapper;

    @Transactional(rollbackFor = Exception.class, timeout = 3)
    public void transferTo(Long selfUserId, Long oppositeUserId, Long amount, String transactionNo) {
        // 1.转账流水入库
        Date now = new Date();
        TransferFlowDO transferFlow = TransferFlowDO.builder()
                                                    .transactionNo(transactionNo)
                                                    .selfUserId(selfUserId)
                                                    .oppositeUserId(oppositeUserId)
                                                    .amount(amount)
                                                    .state((byte) TransferFlowStateEnum.TODO.getStateCode())
                                                    .gmtCreated(now)
                                                    .gmtModified(now)
                                                    .build();
        // 防重(transactionNo 有唯一索引)
        try {
            transferFlowMapper.insert(transferFlow);
        } catch (DuplicateKeyException e) {
            throw new CustomException(BizStatusCode.REPEATED_TRANSFER_REQUEST, e);
        }

        AssetAccount account = accountRepository.find(selfUserId);
        Assert.notNull(account, "账户不存在:" + selfUserId);

        // 2.扣款(带版本号更新）
        account.transferTo(amount);
        accountRepository.save(account);

        // 3.发送事件，通知收款服务方进行处理
        // 注意：事件监听者消费仅关注该事务提交后产生的事件，逻辑见 com.cgx.marketing.application.service.TransferEventAppService
        TransferEvent transferEvent = TransferEvent.builder()
                                                   .transactionNo(transactionNo)
                                                   .selfUserId(selfUserId)
                                                   .oppositeUserId(oppositeUserId)
                                                   .amount(amount)
                                                   .build();
        transferAppEvents.onMoneyDecreased(transferEvent);
    }

}
